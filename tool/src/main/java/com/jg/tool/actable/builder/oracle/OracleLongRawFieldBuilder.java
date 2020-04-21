package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * long raw类型构建器
 * @author gaolj
 */
public class OracleLongRawFieldBuilder extends AbstractOracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.LONG_RAW;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
