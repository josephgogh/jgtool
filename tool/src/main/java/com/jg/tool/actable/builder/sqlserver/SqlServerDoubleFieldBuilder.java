package com.jg.tool.actable.builder.sqlserver;

import com.jg.tool.actable.annotation.Column;

/**
 * numeric类型构建器
 * @author gaolj
 */
public class SqlServerDoubleFieldBuilder extends AbstractSqlServerFieldBuilder {

    @Override
    protected String getFieldType() {
        return "numeric";
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        int maxLength = 38;
        if (length <= 0 || length > maxLength) {
            length = maxLength;
        }
        return length;
    }

    @Override
    protected int getFieldDecimalLength(Column column) {
        int decimalLength = column.decimalLength();
        if (decimalLength <= 0 || decimalLength > 18) {
            decimalLength = 18;
        }
        return decimalLength;
    }
}
