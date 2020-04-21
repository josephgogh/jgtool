package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * raw类型构建器
 * @author gaolj
 */
public class OracleRawFieldBuilder extends AbstractOracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.RAW;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        int maxLength = 2000;
        if (length <= 0 || length > maxLength) {
            length = maxLength;
        }
        return length;
    }

}
