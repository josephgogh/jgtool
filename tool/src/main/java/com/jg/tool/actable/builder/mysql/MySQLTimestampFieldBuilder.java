package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 * timestamp类型构建器
 */
public class MySQLTimestampFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.TIMESTAMP;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
