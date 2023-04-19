package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;

/**
 * long类型构建器
 * @author gaolj
 */
public class OracleLongFieldBuilder extends AbstractOracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return "integer";
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
