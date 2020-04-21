package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * nchar类型构建器
 * @author gaolj
 */
public class OracleNcharFieldBuilder extends AbstractOracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.NCHAR;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        int maxLength = 1000;
        if (length <= 0 || length > maxLength) {
            length = maxLength;
        }
        return length;
    }

}
