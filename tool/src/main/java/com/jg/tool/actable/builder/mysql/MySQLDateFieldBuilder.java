package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 * date类型构建器
 */
public class MySQLDateFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.DATE;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
