package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * float类型构建器
 */
public class OracleFloatFieldBuilder extends OracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.FLOAT;
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
        return 0;
    }
}
