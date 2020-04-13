package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 *  text类型构建器
 */
public class MySQLTextFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.TEXT;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
