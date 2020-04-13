package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * binary_double类型构建器
 */
public class OracleBinaryDoubleFieldBuilder extends OracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.BINARY_DOUBLE;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}