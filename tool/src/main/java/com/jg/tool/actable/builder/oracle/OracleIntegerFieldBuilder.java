package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * integer类型构建器
 */
public class OracleIntegerFieldBuilder extends OracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.INTEGER;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
