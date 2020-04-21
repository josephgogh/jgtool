package com.jg.tool.actable.db;

import cn.hutool.db.Entity;
import com.jg.tool.actable.db.po.FieldStructure;

import java.sql.Connection;
import java.util.List;

/**
 * mysql执行器
 * @author gaolj
 */
public class MySqlDbExecutor extends AbstractDbExecutor {
    public MySqlDbExecutor(Connection connection) {
        super(connection);
    }

    @Override
    public boolean checkTableIsExists(String tableName) {
        String sql = "SELECT count(1) as ct FROM information_schema.TABLES " +
                "where table_schema=database() " +
                "and table_name='" + tableName + "'";
        List<Entity> entityList = query(sql);
        int ct = entityList.get(0).getInt("ct");
        return ct > 0;
    }

    @Override
    public boolean checkTableFieldIsExists(String tableName, String fieldName) {
        String sql = "SELECT count(1) as ct FROM information_schema.columns " +
                "where table_schema=database() " +
                "and table_name='" + tableName + "' " +
                "and column_name = '" + fieldName + "'";
        List<Entity> entityList = query(sql);
        int ct = entityList.get(0).getInt("ct");
        return ct > 0;
    }

    @Override
    public FieldStructure getFieldStructure(String tableName, String fieldName) {
        String sql = "SELECT * FROM information_schema.columns " +
                "where table_schema=database() " +
                "and table_name='" + tableName + "' " +
                "and column_name = '" + fieldName + "'";
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
        if ("PRI".equals(columnKey)) {
            fieldStructure.setKey(true);
        } else {
            fieldStructure.setKey(false);
        }
        String defaulValue = entity.getStr("COLUMN_DEFAULT");
        fieldStructure.setDefaultValue(defaulValue);
        return fieldStructure;
    }

}
