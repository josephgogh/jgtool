package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 * tinyint类型构建器
 */
public class MySQLTinyintFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.TINYINT;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        if (length <= 0 || length > 3) {    //长度值为1-3之间
            length = 3;
        }
        return length;
    }

}
