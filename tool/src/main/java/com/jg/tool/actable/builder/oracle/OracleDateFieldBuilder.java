package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * date类型构建器
 */
public class OracleDateFieldBuilder extends OracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.DATE;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
