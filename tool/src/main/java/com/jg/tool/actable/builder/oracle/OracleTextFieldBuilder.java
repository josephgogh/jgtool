package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;

/**
 * text类型构建器
 * @author gaolj
 */
public class OracleTextFieldBuilder extends AbstractOracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return "clob";
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }
}
