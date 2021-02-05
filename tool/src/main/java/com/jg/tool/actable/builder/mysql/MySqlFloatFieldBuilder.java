package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySqlFieldType;

/**
 * float类型构建器
 * @author gaolj
 */
public class MySqlFloatFieldBuilder extends AbstractMySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySqlFieldType.FLOAT;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        int maxLength = 16;
        if (length <= 0 || length > maxLength) {
            length = maxLength;
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
