package com.jg.tool.actable.db;

import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Entity;
import com.jg.tool.actable.db.po.FieldStructure;

import java.sql.Connection;
import java.util.List;

/**
 * sql server执行器
 * @author gaolj
 * @version 20210205
 */
public class SqlServerDbExecutor extends AbstractDbExecutor {

    public SqlServerDbExecutor(Connection connection) {
        super(connection);
    }

    @Override
    public boolean checkTableIsExists(String tableName) {
        String sql = "SELECT count(1) as CT FROM sys.tables WHERE name='" + tableName + "'";
        List<Entity> entityList = query(sql);
        int ct = entityList.get(0).getInt("CT");
        return ct > 0;
    }

    @Override
    public boolean checkTableFieldIsExists(String tableName, String fieldName) {
        String sql = "SELECT count(1) as CT FROM sys.columns WHERE object_id=object_id('" + tableName + "')" +
                "AND name='" + fieldName + "'";
        List<Entity> entityList = query(sql);
        int ct = entityList.get(0).getInt("CT");
        return ct > 0;
    }

    @Override
    public FieldStructure getFieldStructure(String tableName, String fieldName) {
        String sql = "SELECT A.name AS table_name,B.name AS column_name,D.IS_NULLABLE,D.DATA_TYPE,D.CHARACTER_MAXIMUM_LENGTH,\n" +
                "d.NUMERIC_PRECISION, d.NUMERIC_SCALE,e.ORDINAL_POSITION as COLUMN_KEY, d.COLUMN_DEFAULT\n" +
                "FROM sys.tables A INNER JOIN sys.columns B\n" +
                "ON B.object_id = A.object_id LEFT JOIN sys.extended_properties C\n" +
                "ON C.major_id = B.object_id AND C.minor_id = B.column_id\n" +
                "INNER join INFORMATION_SCHEMA.COLUMNS D on D.COLUMN_NAME=B.name and D.table_name=A.name\n" +
                "left join INFORMATION_SCHEMA.KEY_COLUMN_USAGE e on e.TABLE_NAME = a.name and e.COLUMN_NAME=b.name\n" +
                "WHERE A.name ='" + tableName + "' and b.name='" + fieldName + "'";
        List<Entity> entityList = query(sql);
        if (entityList == null || entityList.size() <= 0) {
            return null;
        }
        Entity entity = entityList.get(0);
        FieldStructure fieldStructure = new FieldStructure();
        fieldStructure.setName(fieldName);
        String dataType = entity.getStr("DATA_TYPE").toLowerCase();
        fieldStructure.setType(dataType);
        Integer dataLength = entity.getInt("CHARACTER_MAXIMUM_LENGTH");
        Integer dataPrecision = entity.getInt("NUMERIC_PRECISION");
        Integer dataScale = entity.getInt("NUMERIC_SCALE");
        if (dataScale != null) {
            fieldStructure.setDecimalLength(dataScale);
        } else {
            fieldStructure.setDecimalLength(-1);
        }
        if (dataPrecision != null) {
            fieldStructure.setLength(dataPrecision);
        } else if(dataLength != null) {
            fieldStructure.setLength(dataLength);
        }
        String nullable = entity.getStr("IS_NULLABLE");
        if ("YES".equals(nullable)) {
            fieldStructure.setNull(true);
        } else {
            fieldStructure.setNull(false);
        }
        String columnKey = entity.getStr("COLUMN_KEY");
        if ("1".equals(columnKey)) {
            fieldStructure.setKey(true);
        } else {
            fieldStructure.setKey(false);
        }
        String defaulValue = entity.getStr("COLUMN_DEFAULT");
        fieldStructure.setDefaultValue(defaulValue);
        return fieldStructure;
    }

    @Override
    public void modifyField(String tableName, List<String> fieldSqlList) {
        for (String fieldSql : fieldSqlList) {
            if (StrUtil.isEmpty(fieldSql)) {
                continue;
            }
            String sql = "alter table " + tableName + " alter column " + fieldSql;
            execute(sql);
        }
    }
}
