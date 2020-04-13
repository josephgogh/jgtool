package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * number类型构建器
 */
public class OracleNumberFieldBuilder extends OracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.NUMBER;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        if (length > 38) {
            length = 38;
        }
        return length;
    }

    @Override
    protected int getFieldDecimalLength(Column column) {
        int decimalLength = column.decimalLength();
        if (decimalLength > 127) {
            decimalLength = 127;
        }
        return decimalLength;
    }
}
