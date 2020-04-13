package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * real类型构建器
 */
public class OracleRealFieldBuilder extends OracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.FLOAT;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

    @Override
    protected int getFieldDecimalLength(Column column) {
        return 0;
    }
}