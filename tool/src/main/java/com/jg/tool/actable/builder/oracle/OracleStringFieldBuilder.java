package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;

/**
 * varchar2类型构建器
 * @author gaolj
 */
public class OracleStringFieldBuilder extends AbstractOracleFieldBuilder {

    @Override
    protected String getFieldType() {
        return "varchar2";
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        if (length <= 0 || length > 4000) {
            length = 400;
        }
        return length;
    }

}
