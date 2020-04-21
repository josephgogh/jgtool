package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * nvarchar2类型构建器
 * @author gaolj
 */
public class OracleNvarchar2FieldBuilder extends AbstractOracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.NVARCHAR2;
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
