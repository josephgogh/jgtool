package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * long类型构建器
 */
public class OracleLongFieldBuilder extends OracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.LONG;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}