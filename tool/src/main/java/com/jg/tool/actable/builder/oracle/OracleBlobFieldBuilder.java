package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * blob类型构建器
 * @author gaolj
 */
public class OracleBlobFieldBuilder extends AbstractOracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.BLOB;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
