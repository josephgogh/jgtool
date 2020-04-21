package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * number类型构建器
 * @author gaolj
 */
public class OracleNumberFieldBuilder extends AbstractOracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.NUMBER;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        int maxLength = 38;
        if (length > maxLength) {
            length = maxLength;
        }
        return length;
    }

    @Override
    protected int getFieldDecimalLength(Column column) {
        int decimalLength = column.decimalLength();
        int maxLength = 127;
        if (decimalLength > maxLength) {
            decimalLength = maxLength;
        }
        return decimalLength;
    }
}
