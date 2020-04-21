package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * binary_float类型构建器
 * @author gaolj
 */
public class OracleBinaryFloatFieldBuilder extends AbstractOracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.BINARY_FLOAT;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
