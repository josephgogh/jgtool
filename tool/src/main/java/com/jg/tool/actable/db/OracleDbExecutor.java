package com.jg.tool.actable.db;

import cn.hutool.db.Entity;
import com.jg.tool.actable.db.po.FieldStructure;

import java.sql.Connection;
import java.util.List;

/**
 * oracle执行器
 */
public class OracleDbExecutor extends DbExecutor {
    public OracleDbExecutor(Connection connection) {
        super(connection);
    }

    @Override
    public boolean checkTableIsExists(String tableName) {
        String sql = "SELECT count(1) as CT FROM tabs WHERE table_name='" + tableName.toUpperCase() + "'";
        List<Entity> entityList = query(sql);
        int ct = entityList.get(0).getInt("CT");
        return ct > 0;
    }

    @Override
    public boolean checkTableFieldIsExists(String tableName, String fieldName) {
        String sql = "SELECT count(1) as CT FROM user_tab_columns WHERE table_name='" + tableName.toUpperCase() + "' " +
                "AND column_name='" + fieldName.toUpperCase() + "'";
        List<Entity> entityList = query(sql);
        int ct = entityList.get(0).getInt("CT");
        return ct > 0;
    }

    @Override
    public FieldStructure getFieldStructure(String tableName, String fieldName) {
        String sql = "SELECT UTC.TABLE_NAME,\n" +
                "       UTC.COLUMN_NAME,\n" +
                "       UTC.DATA_TYPE,\n" +
                "       UTC.DATA_LENGTH,\n" +
                "       UTC.DATA_PRECISION,\n" +
                "       UTC.DATA_SCALE,\n" +
                "       UTC.NULLABLE,\n" +
                "       UTC.DATA_DEFAULT,\n" +
                "       UTC.COLUMN_ID,\n" +
                "       UCC.COMMENTS,\n" +
                "       DECODE(CU.COLUMN_NAME, NULL, 0, 1) AS SFZJ\n" +
                "  FROM USER_TAB_COLUMNS UTC\n" +
                " INNER JOIN USER_COL_COMMENTS UCC\n" +
                "    ON (UTC.TABLE_NAME = UCC.TABLE_NAME AND\n" +
                "       UTC.COLUMN_NAME = UCC.COLUMN_NAME)\n" +
                "  LEFT JOIN (SELECT CU.*\n" +
                "               FROM USER_CONS_COLUMNS CU, USER_CONSTRAINTS AU\n" +
                "              WHERE CU.CONSTRAINT_NAME = AU.CONSTRAINT_NAME\n" +
                "                AND AU.CONSTRAINT_TYPE = 'P') CU\n" +
                "    ON (CU.TABLE_NAME = UCC.TABLE_NAME AND CU.COLUMN_NAME = UCC.COLUMN_NAME)\n" +
                " WHERE UTC.TABLE_NAME = '" + tableName.toUpperCase() + "'\n" +
                "   AND UTC.COLUMN_NAME = '" + fieldName.toUpperCase() + "'\n";
        List<Entity> entityList = query(sql);
        if (entityList == null || entityList.size() <= 0) {
            return null;
        }
        Entity entity = entityList.get(0);
        FieldStructure fieldStructure = new FieldStructure();
        fieldStructure.setName(fieldName);
        String dataType = entity.getStr("DATA_TYPE").toLowerCase();
        fieldStructure.setType(dataType);
        Integer dataLength = entity.getInt("DATA_LENGTH");
        Integer dataPrecision = entity.getInt("DATA_PRECISION");
        Integer dataScale = entity.getInt("DATA_SCALE");
        if (dataScale != null) {
            fieldStructure.setDecimalLength(dataScale);
        } else {
            fieldStructure.setDecimalLength(-1);
        }
        if (dataPrecision != null) {
            fieldStructure.setLength(dataPrecision);
        } else {
            fieldStructure.setLength(dataLength);
        }
        String nullable = entity.getStr("NULLABLE");
        if ("Y".equals(nullable)) {
            fieldStructure.setNull(true);
        } else {
            fieldStructure.setNull(false);
        }
        Integer sfzj = entity.getInt("SFZJ");
        if (sfzj > 0) {
            fieldStructure.setKey(true);
        } else {
            fieldStructure.setKey(false);
        }
        String defaulValue = entity.getStr("DATA_DEFAULT");
        fieldStructure.setDefaultValue(defaulValue);
        return fieldStructure;
    }

}
