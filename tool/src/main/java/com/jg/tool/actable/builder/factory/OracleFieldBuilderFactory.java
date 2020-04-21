package com.jg.tool.actable.builder.factory;

import com.jg.tool.actable.builder.oracle.*;
import com.jg.tool.actable.constant.OracleFieldType;

import java.util.Date;

/**
 * oracle字段构建器工厂
 * @author gaolj
 */
public class OracleFieldBuilderFactory extends AbstractFieldBuilderFactory {

    public OracleFieldBuilderFactory() {
        super();
        add(OracleFieldType.CHAR, new OracleCharFieldBuilder());
        add(OracleFieldType.VARCHAR2, new OracleVarchar2FieldBuilder());
        add(OracleFieldType.NCHAR, new OracleNcharFieldBuilder());
        add(OracleFieldType.NVARCHAR2, new OracleNvarchar2FieldBuilder());
        add(OracleFieldType.DATE, new OracleDateFieldBuilder());
        add(OracleFieldType.LONG, new OracleLongFieldBuilder());
        add(OracleFieldType.RAW, new OracleRawFieldBuilder());
        add(OracleFieldType.LONG_RAW, new OracleLongRawFieldBuilder());
        add(OracleFieldType.BLOB, new OracleBlobFieldBuilder());
        add(OracleFieldType.CLOB, new OracleClobFieldBuilder());
        add(OracleFieldType.NCLOB, new OracleNclobFieldBuilder());
        add(OracleFieldType.NUMBER, new OracleNumberFieldBuilder());
        add(OracleFieldType.INTEGER, new OracleIntegerFieldBuilder());
        add(OracleFieldType.FLOAT, new OracleFloatFieldBuilder());
        add(OracleFieldType.REAL, new OracleRealFieldBuilder());
        add(OracleFieldType.BINARY_FLOAT, new OracleBinaryFloatFieldBuilder());
        add(OracleFieldType.BINARY_DOUBLE, new OracleBinaryDoubleFieldBuilder());

        add(byte.class.getName(), new OracleIntegerFieldBuilder());
        add(Byte.class.getName(), new OracleIntegerFieldBuilder());
        add(short.class.getName(), new OracleIntegerFieldBuilder());
        add(Short.class.getName(), new OracleIntegerFieldBuilder());
        add(int.class.getName(), new OracleIntegerFieldBuilder());
        add(Integer.class.getName(), new OracleIntegerFieldBuilder());
        add(long.class.getName(), new OracleNumberFieldBuilder());
        add(Long.class.getName(), new OracleNumberFieldBuilder());
        add(float.class.getName(), new OracleBinaryFloatFieldBuilder());
        add(Float.class.getName(), new OracleBinaryFloatFieldBuilder());
        add(double.class.getName(), new OracleBinaryDoubleFieldBuilder());
        add(Double.class.getName(), new OracleBinaryDoubleFieldBuilder());
        add(char.class.getName(), new OracleCharFieldBuilder());
        add(String.class.getName(), new OracleVarchar2FieldBuilder());
        add(Date.class.getName(), new OracleDateFieldBuilder());
    }

}
