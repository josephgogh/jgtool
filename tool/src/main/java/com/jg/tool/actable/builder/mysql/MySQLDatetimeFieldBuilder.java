package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 * datetime类型构建器
 */
public class MySQLDatetimeFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.DATETIME;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
