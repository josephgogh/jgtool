package com.jg.tool.actable.builder.factory;

import com.jg.tool.actable.builder.sqlserver.*;
import com.jg.tool.actable.constant.FieldType;

import java.util.Date;

/**
 * sql server字段构建工厂
 * @author gaolj
 * @version 20210205
 */
public class SqlServerFieldBuilderFactory extends AbstractFieldBuilderFactory {

    public SqlServerFieldBuilderFactory() {
        super();
        add(FieldType.LONG, new SqlServerLongFieldBuilder());
        add(FieldType.DOUBLE, new SqlServerDoubleFieldBuilder());
        add(FieldType.STRING, new SqlServerStringFieldBuilder());
        add(FieldType.TEXT, new SqlServerTextFieldBuilder());
        add(FieldType.DATETIME, new SqlServerDatetimeFieldBuilder());

        add(byte.class.getName(), new SqlServerLongFieldBuilder());
        add(Byte.class.getName(), new SqlServerLongFieldBuilder());
        add(short.class.getName(), new SqlServerLongFieldBuilder());
        add(Short.class.getName(), new SqlServerLongFieldBuilder());
        add(int.class.getName(), new SqlServerLongFieldBuilder());
        add(Integer.class.getName(), new SqlServerLongFieldBuilder());
        add(long.class.getName(), new SqlServerLongFieldBuilder());
        add(Long.class.getName(), new SqlServerLongFieldBuilder());
        add(float.class.getName(), new SqlServerDoubleFieldBuilder());
        add(Float.class.getName(), new SqlServerDoubleFieldBuilder());
        add(double.class.getName(), new SqlServerDoubleFieldBuilder());
        add(Double.class.getName(), new SqlServerDoubleFieldBuilder());
        add(char.class.getName(), new SqlServerStringFieldBuilder());
        add(String.class.getName(), new SqlServerStringFieldBuilder());
        add(Date.class.getName(), new SqlServerDatetimeFieldBuilder());
    }
}
