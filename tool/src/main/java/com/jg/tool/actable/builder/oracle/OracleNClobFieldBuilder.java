package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * nclob类型构建器
 */
public class OracleNClobFieldBuilder extends OracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.NCLOB;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
