package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 * varchar类型构建器
 */
public class MySQLVarcharFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.VARCHAR;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        if (length <= 0) {
            length = 255;
        }
        if (length > 21845) {
            length = 21845;
        }
        return length;
    }

}
