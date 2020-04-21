package com.jg.tool.actable.db;

import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.handler.EntityListHandler;
import cn.hutool.db.sql.SqlExecutor;
import cn.hutool.log.LogFactory;
import com.jg.tool.actable.ACTable;
import com.jg.tool.actable.db.po.FieldStructure;
import com.jg.tool.exception.ACTableException;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库执行者
 * @author gaolj
 */
public abstract class AbstractDbExecutor {

    private Connection connection;

    public AbstractDbExecutor(Connection connection) {
        this.connection = connection;
    }

    /**
     * 执行非查询语句
     * @param sql
     * @return
     */
    public int execute(String sql) {
        return execute(sql, new HashMap<>());
    }

    /**
     * 执行非查询语句
     * @param sql
     * @param params
     * @return
     */
    public int execute(String sql, Map<String, Object> params) {
        int result;
        try {
            LogFactory.get(ACTable.class).debug("执行sql操作：" + sql);
            result = SqlExecutor.execute(connection, sql, params);
        } catch (Exception e) {
            throw new ACTableException(e);
        }
        return result;
    }

    /**
     * 查询
     * @param sql
     * @return
     */
    public List<Entity> query(String sql) {
        return query(sql, new HashMap<>());
    }

    /**
     * 查询
     * @param sql
     * @param params
     * @return
     */
    public List<Entity> query(String sql, Map<String, Object> params) {
        List<Entity> result;
        try {
            result = SqlExecutor.query(connection, sql, new EntityListHandler(), params);
        } catch (Exception e) {
            throw new ACTableException(e);
        }
        return result;
    }

    /**
     * 校验表是否存在
     * @param tableName
     * @return  true：存在；false：不存在
     */
    public abstract boolean checkTableIsExists(String tableName);

    /**
     * 检验表中字段是否存在
     * @param tableName
     * @param fieldName
     * @return
     */
    public abstract boolean checkTableFieldIsExists(String tableName, String fieldName);

    /**
     * 新增字段
     * @param tableName 表名
     * @param fieldSqlList  表字段列表
     */
    public void addField(String tableName, List<String> fieldSqlList) {
        for (String fieldSql : fieldSqlList) {
            if (StrUtil.isEmpty(fieldSql)) {
                continue;
            }
            String sql = "alter table " + tableName + " add " + fieldSql;
            execute(sql);
        }
    }

    /**
     * 修改字段
     * @param tableName 表名
     * @param fieldSqlList  表字段列表
     */
    public void modifyField(String tableName, List<String> fieldSqlList) {
        for (String fieldSql : fieldSqlList) {
            if (StrUtil.isEmpty(fieldSql)) {
                continue;
            }
            String sql = "alter table " + tableName + " modify " + fieldSql;
            execute(sql);
        }
    }

    /**
     * 创建表
     * @param tableName 表名
     * @param fieldSqlList  表字段列表
     */
    public void createTable(String tableName, List<String> fieldSqlList) {
        if (fieldSqlList == null || fieldSqlList.size() <= 0) {
            return ;
        }
        StringBuilder sql = new StringBuilder("create table ").append(tableName).append(" (");
        for (String fieldSql : fieldSqlList) {
            if (StrUtil.isEmpty(fieldSql)) {
                continue;
            }
            sql.append(fieldSql).append(",");
        }
        sql.delete(sql.length() - 1, sql.length());
        sql.append(")");
        execute(sql.toString());
    }

    /**
     * 删除表
     * @param tableName
     */
    public void dropTable(String tableName) {
        String sql = "drop table " + tableName;
        execute(sql);
    }

    /**
     * 获取字段结构
     * @param tableName
     * @param fieldName
     * @return
     */
    public abstract FieldStructure getFieldStructure(String tableName, String fieldName);
}
