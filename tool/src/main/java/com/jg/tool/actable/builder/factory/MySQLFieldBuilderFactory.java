package com.jg.tool.actable.builder.factory;

import com.jg.tool.actable.builder.mysql.*;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 * mysql字段构建器工厂
 */
public class MySQLFieldBuilderFactory extends FieldBuilderFactory {

    public MySQLFieldBuilderFactory() {
        super();
        add(MySQLFieldType.TINYINT, new MySQLTinyintFieldBuilder());
        add(MySQLFieldType.SMALLINT, new MySQLSmallintFieldBuilder());
        add(MySQLFieldType.MEDIUMINT, new MySQLMediumintFieldBuilder());
        add(MySQLFieldType.INT, new MySQLIntFieldBuilder());
        add(MySQLFieldType.BIGINT, new MySQLBigintFieldBuilder());
        add(MySQLFieldType.FLOAT, new MySQLFloatFieldBuilder());
        add(MySQLFieldType.DOUBLE, new MySQLDoubleFieldBuilder());
        add(MySQLFieldType.NUMERIC, new MySQLNumericFieldBuilder());
        add(MySQLFieldType.DATE, new MySQLDateFieldBuilder());
        add(MySQLFieldType.DATETIME, new MySQLDatetimeFieldBuilder());
        add(MySQLFieldType.TIMESTAMP, new MySQLTimestampFieldBuilder());
        add(MySQLFieldType.TIME, new MySQLTimeFieldBuilder());
        add(MySQLFieldType.YEAR, new MySQLYearFieldBuilder());
        add(MySQLFieldType.CHAR, new MySQLCharFieldBuilder());
        add(MySQLFieldType.VARCHAR, new MySQLVarcharFieldBuilder());
        add(MySQLFieldType.TINYBLOB, new MySQLTinyblobFieldBuilder());
        add(MySQLFieldType.TINYTEXT, new MySQLTinytextFieldBuilder());
        add(MySQLFieldType.BLOB, new MySQLBlobFieldBuilder());
        add(MySQLFieldType.TEXT, new MySQLTextFieldBuilder());
        add(MySQLFieldType.MEDIUMBLOB, new MySQLMediumblobFieldBuilder());
        add(MySQLFieldType.MEDIUMTEXT, new MySQLMediumtextFieldBuilder());
        add(MySQLFieldType.LONGBLOB, new MySQLLongblobFieldBuilder());
        add(MySQLFieldType.LONGTEXT, new MySQLLongtextFieldBuilder());

        add(byte.class.getName(), new MySQLTinyintFieldBuilder());
        add(Byte.class.getName(), new MySQLTinyintFieldBuilder());
        add(short.class.getName(), new MySQLSmallintFieldBuilder());
        add(Short.class.getName(), new MySQLSmallintFieldBuilder());
        add(int.class.getName(), new MySQLIntFieldBuilder());
        add(Integer.class.getName(), new MySQLIntFieldBuilder());
        add(long.class.getName(), new MySQLBigintFieldBuilder());
        add(Long.class.getName(), new MySQLBigintFieldBuilder());
        add(float.class.getName(), new MySQLFloatFieldBuilder());
        add(Float.class.getName(), new MySQLFloatFieldBuilder());
        add(double.class.getName(), new MySQLDoubleFieldBuilder());
        add(Double.class.getName(), new MySQLDoubleFieldBuilder());
        add(char.class.getName(), new MySQLCharFieldBuilder());
        add(String.class.getName(), new MySQLVarcharFieldBuilder());
    }

}
