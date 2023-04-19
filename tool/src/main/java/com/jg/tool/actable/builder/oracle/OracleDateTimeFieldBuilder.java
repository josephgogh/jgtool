package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;

/**
 * date类型构建器
 * @author gaolj
 */
public class OracleDateTimeFieldBuilder extends AbstractOracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return "date";
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
