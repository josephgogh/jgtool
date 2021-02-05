package com.jg.tool.actable.builder.factory;

import com.jg.tool.actable.builder.sqlserver.*;
import com.jg.tool.actable.constant.SqlServerFieldType;

import java.util.Date;

/**
 * sql server字段构建工厂
 * @author gaolj
 * @version 20210205
 */
public class SqlServerFieldBuilderFactory extends AbstractFieldBuilderFactory {

    public SqlServerFieldBuilderFactory() {
        super();
        add(SqlServerFieldType.BIT, new SqlServerBitFieldBuilder());
        add(SqlServerFieldType.TINYINT, new SqlServerTinyintFieldBuilder());
        add(SqlServerFieldType.SMALLINT, new SqlServerSmallintFieldBuilder());
        add(SqlServerFieldType.INT, new SqlServerIntFieldBuilder());
        add(SqlServerFieldType.BIGINT, new SqlServerBigintFieldBuilder());
        add(SqlServerFieldType.DECIMAL, new SqlServerDecimalFieldBuilder());
        add(SqlServerFieldType.NUMERIC, new SqlServerNumericFieldBuilder());
        add(SqlServerFieldType.SMALLMONEY, new SqlServerSmallmoneyFieldBuilder());
        add(SqlServerFieldType.MONEY, new SqlServerMoneyFieldBuilder());
        add(SqlServerFieldType.FLOAT, new SqlServerFloatFieldBuilder());
        add(SqlServerFieldType.REAL, new SqlServerRealFieldBuilder());
        add(SqlServerFieldType.SMALLDATETIME, new SqlServerSmalldatetimeFieldBuilder());
        add(SqlServerFieldType.DATE, new SqlServerDateFieldBuilder());
        add(SqlServerFieldType.DATETIME, new SqlServerDatetimeFieldBuilder());
        add(SqlServerFieldType.TIMESTAMP, new SqlServerTimestampFieldBuilder());
        add(SqlServerFieldType.UNIQUEIDENTIFIER, new SqlServerUniqueidentifierFieldBuilder());
        add(SqlServerFieldType.CHAR, new SqlServerCharFieldBuilder());
        add(SqlServerFieldType.VARCHAR, new SqlServerVarcharFieldBuilder());
        add(SqlServerFieldType.TEXT, new SqlServerTextFieldBuilder());
        add(SqlServerFieldType.NCHAR, new SqlServerNcharFieldBuilder());
        add(SqlServerFieldType.NVARCHAR, new SqlServerNvarcharFieldBuilder());
        add(SqlServerFieldType.NTEXT, new SqlServerNtextFieldBuilder());
        add(SqlServerFieldType.BINARY, new SqlServerBinaryFieldBuilder());
        add(SqlServerFieldType.VARBINARY, new SqlServerVarbinaryFieldBuilder());
        add(SqlServerFieldType.IMAGE, new SqlServerImageFieldBuilder());

        add(byte.class.getName(), new SqlServerIntFieldBuilder());
        add(Byte.class.getName(), new SqlServerIntFieldBuilder());
        add(short.class.getName(), new SqlServerIntFieldBuilder());
        add(Short.class.getName(), new SqlServerIntFieldBuilder());
        add(int.class.getName(), new SqlServerIntFieldBuilder());
        add(Integer.class.getName(), new SqlServerIntFieldBuilder());
        add(long.class.getName(), new SqlServerBigintFieldBuilder());
        add(Long.class.getName(), new SqlServerBigintFieldBuilder());
        add(float.class.getName(), new SqlServerFloatFieldBuilder());
        add(Float.class.getName(), new SqlServerFloatFieldBuilder());
        add(double.class.getName(), new SqlServerDecimalFieldBuilder());
        add(Double.class.getName(), new SqlServerDecimalFieldBuilder());
        add(char.class.getName(), new SqlServerCharFieldBuilder());
        add(String.class.getName(), new SqlServerVarcharFieldBuilder());
        add(Date.class.getName(), new SqlServerDatetimeFieldBuilder());
    }
}
