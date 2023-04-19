package com.jg.tool.actable.builder.factory;

import com.jg.tool.actable.builder.mysql.*;
import com.jg.tool.actable.constant.FieldType;

import java.util.Date;

/**
 * mysql字段构建器工厂
 * @author gaolj
 */
public class MySqlFieldBuilderFactory extends AbstractFieldBuilderFactory {

    public MySqlFieldBuilderFactory() {
        super();
        add(FieldType.LONG, new MySqlLongFieldBuilder());
        add(FieldType.DOUBLE, new MySqlDoubleFieldBuilder());
        add(FieldType.STRING, new MySqlStringFieldBuilder());
        add(FieldType.TEXT, new MySqlTextFieldBuilder());
        add(FieldType.DATETIME, new MySqlDatetimeFieldBuilder());

        add(byte.class.getName(), new MySqlLongFieldBuilder());
        add(Byte.class.getName(), new MySqlLongFieldBuilder());
        add(short.class.getName(), new MySqlLongFieldBuilder());
        add(Short.class.getName(), new MySqlLongFieldBuilder());
        add(int.class.getName(), new MySqlLongFieldBuilder());
        add(Integer.class.getName(), new MySqlLongFieldBuilder());
        add(long.class.getName(), new MySqlLongFieldBuilder());
        add(Long.class.getName(), new MySqlLongFieldBuilder());
        add(float.class.getName(), new MySqlDoubleFieldBuilder());
        add(Float.class.getName(), new MySqlDoubleFieldBuilder());
        add(double.class.getName(), new MySqlDoubleFieldBuilder());
        add(Double.class.getName(), new MySqlDoubleFieldBuilder());
        add(char.class.getName(), new MySqlStringFieldBuilder());
        add(String.class.getName(), new MySqlStringFieldBuilder());
        add(Date.class.getName(), new MySqlDatetimeFieldBuilder());
    }

}
