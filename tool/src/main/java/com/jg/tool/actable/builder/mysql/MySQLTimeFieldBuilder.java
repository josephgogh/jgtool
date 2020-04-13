package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 * time类型构建器
 */
public class MySQLTimeFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.TIME;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
