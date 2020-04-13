package com.jg.tool.actable.execute;

import cn.hutool.core.util.StrUtil;
import com.jg.tool.actable.ACTable;
import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.annotation.Table;
import com.jg.tool.actable.builder.FieldBuilder;
import com.jg.tool.actable.builder.factory.FieldBuilderFactory;
import com.jg.tool.actable.constant.AutoType;
import com.jg.tool.actable.db.DbExecutor;
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
 */
public abstract class Executor {

    protected ACTable acTable;
    protected DbExecutor dbExecutor;
    protected FieldBuilderFactory fieldBuilderFactory;

    protected Class<?> cls; //类
    protected String tableName; //表名
    protected List<Field> fieldList;    //字段列表

    public Executor(ACTable acTable) {
        this.acTable = acTable;
        dbExecutor = this.buildDbExecutor();
        fieldBuilderFactory = this.buildFieldBuilderFactory();
    }

    /**
     * 构建字段构建器工厂
     * @return
     */
    protected abstract FieldBuilderFactory buildFieldBuilderFactory();

    /**
     * 构建数据库执行器
     */
    protected abstract DbExecutor buildDbExecutor();

    /**
     * 获取执行者
     */
    public static Executor getExecutor(ACTable acTable) {
        switch (acTable.getDbType()) {
            case MYSQL: return new MySQLExecutor(acTable);
            case ORACLE: return new OracleExecutor(acTable);
            default:throw new ACTableException("暂不支持此数据库！");
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
        }
    }

    /**
     * 执行更新模式
     * autoType: update
     */
    private void executeUpdate() {
        boolean isExistsTable = dbExecutor.checkTableIsExists(this.tableName);
        List<String> fieldInsertSqlList = new ArrayList<>();
        List<String> fieldUpdateSqlList = new ArrayList<>();
        for (Field field : EmptyObject.list(this.fieldList)) {  //遍历字段
            Column column = field.getAnnotation(Column.class);
            FieldBuilder fieldBuilder = this.fieldBuilderFactory.getFieldBuilder(field, column);
            if (fieldBuilder == null) {
                throw new ACTableException("暂不支持此数据类型的构建！类名：" + this.cls.getName() + ",字段名：" + field.getName());
            }
            String fieldName = ColumnUtil.getTableFieldName(field, column);
            if (isExistsTable) {    //表存在的时候，校验字段是否存在
                boolean isExistsTableField = dbExecutor.checkTableFieldIsExists(this.tableName, fieldName);
                if (isExistsTableField) {   //存在字段的时候执行更新
                    FieldStructure fieldStructure = dbExecutor.getFieldStructure(this.tableName, fieldName);
                    String buildSql = fieldBuilder.buildModify(field, column, fieldStructure);
                    fieldUpdateSqlList.add(buildSql);
                    continue;
                }
            }
            String buildSql = fieldBuilder.build(field, column);
            fieldInsertSqlList.add(buildSql);
        }
        if (isExistsTable) {    //存在表的时候，执行表新增字段和表更新字段
            dbExecutor.addField(this.tableName, fieldInsertSqlList);
            dbExecutor.modifyField(this.tableName, fieldUpdateSqlList);
        } else {    //不存在表的时候，执行表创建
            dbExecutor.createTable(this.tableName, fieldInsertSqlList);
        }
    }

    /**
     * 执行创建模式
     * autoType: create
     */
    private void executeCreate() {
        List<String> fieldSqlList = new ArrayList<>();
        for (Field field : EmptyObject.list(this.fieldList)) {  //遍历字段
            Column column = field.getAnnotation(Column.class);
            String fieldName = ColumnUtil.getTableFieldName(field, column);
            FieldBuilder fieldBuilder = this.fieldBuilderFactory.getFieldBuilder(field, column);
            if (fieldBuilder == null) {
                throw new ACTableException("暂不支持此数据类型的构建！类名：" + this.cls.getName() + ",字段名：" + field.getName());
            }
            String buildSql = fieldBuilder.build(field, column);
            fieldSqlList.add(buildSql);
        }
        if (fieldSqlList.size() <= 0) {
            return ;
        }
        boolean isExistsTable = dbExecutor.checkTableIsExists(this.tableName);
        if (isExistsTable) {
            dbExecutor.dropTable(this.tableName);
        }
        dbExecutor.createTable(this.tableName, fieldSqlList);
    }

    /**
     * 执行插入模式
     * autoType: insert
     */
    private void executeInsert() {
        boolean isExistsTable = dbExecutor.checkTableIsExists(this.tableName);
        List<String> fieldSqlList = new ArrayList<>();
        for (Field field : EmptyObject.list(this.fieldList)) {  //遍历字段
            Column column = field.getAnnotation(Column.class);
            String fieldName = ColumnUtil.getTableFieldName(field, column);
            if (isExistsTable) {    //表存在的时候，校验字段是否存在
                boolean isExistsTableField = dbExecutor.checkTableFieldIsExists(this.tableName, fieldName);
                if (isExistsTableField) {
                    continue;
                }
            }
            FieldBuilder fieldBuilder = this.fieldBuilderFactory.getFieldBuilder(field, column);
            if (fieldBuilder == null) {
                throw new ACTableException("暂不支持此数据类型的构建！类名：" + this.cls.getName() + ",字段名：" + field.getName());
            }
            String buildSql = fieldBuilder.build(field, column);
            fieldSqlList.add(buildSql);
        }
        if (isExistsTable) {    //存在表的时候，执行表新增字段
            dbExecutor.addField(this.tableName, fieldSqlList);
        } else {    //不存在表的时候，执行表创建
            dbExecutor.createTable(this.tableName, fieldSqlList);
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
        if (StrUtil.isNotEmpty(name)) { //不为空，则设置值为表名
            this.tableName = name;
        } else {    //为空，则将类名进行驼峰转换之后设置为表名
            this.tableName = StrTool.fromHump(cls.getSimpleName());
        }
    }

}
