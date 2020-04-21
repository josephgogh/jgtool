package com.jg.tool.actable.builder.factory;

import com.jg.tool.actable.builder.mysql.*;
import com.jg.tool.actable.constant.MySqlFieldType;

import java.util.Date;

/**
 * mysql字段构建器工厂
 * @author gaolj
 */
public class MySqlFieldBuilderFactory extends AbstractFieldBuilderFactory {

    public MySqlFieldBuilderFactory() {
        super();
        add(MySqlFieldType.TINYINT, new MySqlTinyintFieldBuilder());
        add(MySqlFieldType.SMALLINT, new MySqlSmallintFieldBuilder());
        add(MySqlFieldType.MEDIUMINT, new MySqlMediumintFieldBuilder());
        add(MySqlFieldType.INT, new MySqlIntFieldBuilder());
        add(MySqlFieldType.BIGINT, new MySqlBigintFieldBuilder());
        add(MySqlFieldType.FLOAT, new MySqlFloatFieldBuilder());
        add(MySqlFieldType.DOUBLE, new MySqlDoubleFieldBuilder());
        add(MySqlFieldType.NUMERIC, new MySqlNumericFieldBuilder());
        add(MySqlFieldType.DATE, new MySqlDateFieldBuilder());
        add(MySqlFieldType.DATETIME, new MySqlDatetimeFieldBuilder());
        add(MySqlFieldType.TIMESTAMP, new MySqlTimestampFieldBuilder());
        add(MySqlFieldType.TIME, new MySqlTimeFieldBuilder());
        add(MySqlFieldType.YEAR, new MySqlYearFieldBuilder());
        add(MySqlFieldType.CHAR, new MySqlCharFieldBuilder());
        add(MySqlFieldType.VARCHAR, new MySqlVarcharFieldBuilder());
        add(MySqlFieldType.TINYBLOB, new MySqlTinyblobFieldBuilder());
        add(MySqlFieldType.TINYTEXT, new MySqlTinytextFieldBuilder());
        add(MySqlFieldType.BLOB, new MySqlBlobFieldBuilder());
        add(MySqlFieldType.TEXT, new MySqlTextFieldBuilder());
        add(MySqlFieldType.MEDIUMBLOB, new MySqlMediumblobFieldBuilder());
        add(MySqlFieldType.MEDIUMTEXT, new MySqlMediumtextFieldBuilder());
        add(MySqlFieldType.LONGBLOB, new MySqlLongblobFieldBuilder());
        add(MySqlFieldType.LONGTEXT, new MySqlLongtextFieldBuilder());

        add(byte.class.getName(), new MySqlTinyintFieldBuilder());
        add(Byte.class.getName(), new MySqlTinyintFieldBuilder());
        add(short.class.getName(), new MySqlSmallintFieldBuilder());
        add(Short.class.getName(), new MySqlSmallintFieldBuilder());
        add(int.class.getName(), new MySqlIntFieldBuilder());
        add(Integer.class.getName(), new MySqlIntFieldBuilder());
        add(long.class.getName(), new MySqlBigintFieldBuilder());
        add(Long.class.getName(), new MySqlBigintFieldBuilder());
        add(float.class.getName(), new MySqlFloatFieldBuilder());
        add(Float.class.getName(), new MySqlFloatFieldBuilder());
        add(double.class.getName(), new MySqlDoubleFieldBuilder());
        add(Double.class.getName(), new MySqlDoubleFieldBuilder());
        add(char.class.getName(), new MySqlCharFieldBuilder());
        add(String.class.getName(), new MySqlVarcharFieldBuilder());
        add(Date.class.getName(), new MySqlDatetimeFieldBuilder());
    }

}
