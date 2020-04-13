package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 * numeric类型构建器
 */
public class MySQLNumericFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.NUMERIC;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        if (length <= 0 || length > 65) {
            length = 65;
        }
        return length;
    }

    @Override
    protected int getFieldDecimalLength(Column column) {
        int decimalLength = column.decimalLength();
        if (decimalLength <= 0 || decimalLength > 10) {
            decimalLength = 10;
        }
        return decimalLength;
    }
}
