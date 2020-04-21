package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.OracleFieldType;

/**
 * varchar2类型构建器
 * @author gaolj
 */
public class OracleVarchar2FieldBuilder extends AbstractOracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return OracleFieldType.VARCHAR2;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        int maxLength = 4000;
        if (length <= 0 || length > maxLength) {
            length = maxLength;
        }
        return length;
    }

}
