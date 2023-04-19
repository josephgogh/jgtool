package com.jg.tool.actable.builder.factory;

import com.jg.tool.actable.builder.oracle.*;
import com.jg.tool.actable.constant.FieldType;

import java.util.Date;

/**
 * oracle字段构建器工厂
 * @author gaolj
 */
public class OracleFieldBuilderFactory extends AbstractFieldBuilderFactory {

    public OracleFieldBuilderFactory() {
        super();
        add(FieldType.LONG, new OracleLongFieldBuilder());
        add(FieldType.DOUBLE, new OracleDoubleFieldBuilder());
        add(FieldType.STRING, new OracleStringFieldBuilder());
        add(FieldType.TEXT, new OracleTextFieldBuilder());
        add(FieldType.DATETIME, new OracleDateTimeFieldBuilder());

        add(byte.class.getName(), new OracleLongFieldBuilder());
        add(Byte.class.getName(), new OracleLongFieldBuilder());
        add(short.class.getName(), new OracleLongFieldBuilder());
        add(Short.class.getName(), new OracleLongFieldBuilder());
        add(int.class.getName(), new OracleLongFieldBuilder());
        add(Integer.class.getName(), new OracleLongFieldBuilder());
        add(long.class.getName(), new OracleDoubleFieldBuilder());
        add(Long.class.getName(), new OracleDoubleFieldBuilder());
        add(float.class.getName(), new OracleDoubleFieldBuilder());
        add(Float.class.getName(), new OracleDoubleFieldBuilder());
        add(double.class.getName(), new OracleDoubleFieldBuilder());
        add(Double.class.getName(), new OracleDoubleFieldBuilder());
        add(char.class.getName(), new OracleStringFieldBuilder());
        add(String.class.getName(), new OracleStringFieldBuilder());
        add(Date.class.getName(), new OracleDateTimeFieldBuilder());
    }

}
