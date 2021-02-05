package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySqlFieldType;

/**
 * double类型构建器
 * @author gaolj
 */
public class MySqlDoubleFieldBuilder extends AbstractMySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySqlFieldType.DOUBLE;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        if (length <= 0 || length > 24) {
            length = 24;
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
