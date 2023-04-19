package com.jg.tool.actable.execute;

import cn.hutool.core.util.StrUtil;
import com.jg.tool.actable.ACTable;
import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.annotation.Table;
import com.jg.tool.actable.builder.AbstractFieldBuilder;
import com.jg.tool.actable.builder.factory.AbstractFieldBuilderFactory;
import com.jg.tool.actable.constant.AutoType;
import com.jg.tool.actable.db.AbstractDbExecutor;
import com.jg.tool.actable.db.po.FieldStructure;
import com.jg.tool.actable.util.ColumnUtil;
import com.jg.tool.empty.EmptyObject;
import com.jg.tool.exception.ACTableException;
import com.jg.tool.util.ClassTool;
import com.jg.tool.util.StrTool;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 执行器抽象类
 * @author gaolj
 */
public abstract class AbstractExecutor {

    protected ACTable acTable;
    protected AbstractDbExecutor abstractDbExecutor;
    protected AbstractFieldBuilderFactory abstractFieldBuilderFactory;

    /**
     * 类
     */
    protected Class<?> cls;

    /**
     * 表名
     */
    protected String tableName;

    /**
     * 字段列表
     */
    protected List<Field> fieldList;

    public AbstractExecutor(ACTable acTable) {
        this.acTable = acTable;
        abstractDbExecutor = this.buildDbExecutor();
        abstractFieldBuilderFactory = this.buildFieldBuilderFactory();
    }

    /**
     * 构建字段构建器工厂
     * @return
     */
    protected abstract AbstractFieldBuilderFactory buildFieldBuilderFactory();

    /**
     * 构建数据库执行器
     * @return
     */
    protected abstract AbstractDbExecutor buildDbExecutor();

    /**
     * 获取执行者
     */
    public static AbstractExecutor getExecutor(ACTable acTable) {
        switch (acTable.getDbType()) {
            case MYSQL: return new MySqlExecutor(acTable);
            case ORACLE: return new OracleExecutor(acTable);
            case SQLSERVER: return new SqlServerExecutor(acTable);
            default:throw new ACTableException("This database is not currently supported！");
        }
    }

    /**
     * 执行
     */
    public void execute(Class<?> cls) {
        this.cls = cls;
        this.buildTableName(cls);
        this.buildFieldList(cls);
        switch (acTable.getAutoType()) {
            case AutoType.CREATE:
                executeCreate();
                break;
            case AutoType.INSERT:
                executeInsert();
                break;
            case AutoType.UPDATE:
                executeUpdate();
                break;
            default: break;
        }
    }

    /**
     * 执行更新模式
     * autoType: update
     */
    private void executeUpdate() {
        boolean isExistsTable = abstractDbExecutor.checkTableIsExists(this.tableName);
        List<String> fieldInsertSqlList = new ArrayList<>();
        List<String> fieldUpdateSqlList = new ArrayList<>();
        for (Field field : EmptyObject.list(this.fieldList)) {
            //遍历字段
            Column column = field.getAnnotation(Column.class);
            AbstractFieldBuilder abstractFieldBuilder = this.abstractFieldBuilderFactory.getFieldBuilder(field, column);
            if (abstractFieldBuilder == null) {
                throw new ACTableException("Construction of this data type is currently not supported！ClassName：" + this.cls.getName() + ",FieldName：" + field.getName());
            }
            String fieldName = ColumnUtil.getTableFieldName(field, column);
            if (isExistsTable) {
                //表存在的时候，校验字段是否存在
                boolean isExistsTableField = abstractDbExecutor.checkTableFieldIsExists(this.tableName, fieldName);
                if (isExistsTableField) {
                    //存在字段的时候执行更新
                    FieldStructure fieldStructure = abstractDbExecutor.getFieldStructure(this.tableName, fieldName);
                    String buildSql = abstractFieldBuilder.buildModify(field, column, fieldStructure);
                    fieldUpdateSqlList.add(buildSql);
                    continue;
                }
            }
            String buildSql = abstractFieldBuilder.build(field, column);
            fieldInsertSqlList.add(buildSql);
        }
        if (isExistsTable) {
            //存在表的时候，执行表新增字段和表更新字段
            abstractDbExecutor.addField(this.tableName, fieldInsertSqlList);
            abstractDbExecutor.modifyField(this.tableName, fieldUpdateSqlList);
        } else {    //不存在表的时候，执行表创建
            abstractDbExecutor.createTable(this.tableName, fieldInsertSqlList);
        }
    }

    /**
     * 执行创建模式
     * autoType: create
     */
    private void executeCreate() {
        List<String> fieldSqlList = new ArrayList<>();
        for (Field field : EmptyObject.list(this.fieldList)) {
            //遍历字段
            Column column = field.getAnnotation(Column.class);
            AbstractFieldBuilder abstractFieldBuilder = this.abstractFieldBuilderFactory.getFieldBuilder(field, column);
            if (abstractFieldBuilder == null) {
                throw new ACTableException("Construction of this data type is currently not supported！ClassName：" + this.cls.getName() + ",FieldName：" + field.getName());
            }
            String buildSql = abstractFieldBuilder.build(field, column);
            fieldSqlList.add(buildSql);
        }
        if (fieldSqlList.size() <= 0) {
            return ;
        }
        boolean isExistsTable = abstractDbExecutor.checkTableIsExists(this.tableName);
        if (isExistsTable) {
            abstractDbExecutor.dropTable(this.tableName);
        }
        abstractDbExecutor.createTable(this.tableName, fieldSqlList);
    }

    /**
     * 执行插入模式
     * autoType: insert
     */
    private void executeInsert() {
        boolean isExistsTable = abstractDbExecutor.checkTableIsExists(this.tableName);
        List<String> fieldSqlList = new ArrayList<>();
        for (Field field : EmptyObject.list(this.fieldList)) {
            //遍历字段
            Column column = field.getAnnotation(Column.class);
            String fieldName = ColumnUtil.getTableFieldName(field, column);
            if (isExistsTable) {
                //表存在的时候，校验字段是否存在
                boolean isExistsTableField = abstractDbExecutor.checkTableFieldIsExists(this.tableName, fieldName);
                if (isExistsTableField) {
                    continue;
                }
            }
            AbstractFieldBuilder abstractFieldBuilder = this.abstractFieldBuilderFactory.getFieldBuilder(field, column);
            if (abstractFieldBuilder == null) {
                throw new ACTableException("Construction of this data type is currently not supported！ClassName：" + this.cls.getName() + ",FieldName：" + field.getName());
            }
            String buildSql = abstractFieldBuilder.build(field, column);
            fieldSqlList.add(buildSql);
        }
        if (isExistsTable) {
            //存在表的时候，执行表新增字段
            abstractDbExecutor.addField(this.tableName, fieldSqlList);
        } else {    //不存在表的时候，执行表创建
            abstractDbExecutor.createTable(this.tableName, fieldSqlList);
        }
    }

    /**
     * 构建需要插入的表字段列表
     * @param cls
     */
    private void buildFieldList(Class<?> cls) {
        this.fieldList = ClassTool.getFieldsContainSuper(cls, field -> field.isAnnotationPresent(Column.class));
    }

    /**
     * 构建表名
     * @param cls
     * @return
     */
    private void buildTableName(Class<?> cls) {
        Table table = cls.getAnnotation(Table.class);
        String name = table.value();
        if (StrUtil.isNotEmpty(name)) {
            //不为空，则设置值为表名
            this.tableName = name;
        } else {
            //为空，则将类名进行驼峰转换之后设置为表名
            this.tableName = StrTool.fromHump(cls.getSimpleName());
        }
    }

}
