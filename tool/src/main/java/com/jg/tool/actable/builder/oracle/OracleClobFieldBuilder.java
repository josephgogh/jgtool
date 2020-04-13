package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * clob类型构建器
 */
public class OracleClobFieldBuilder extends OracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.CLOB;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}