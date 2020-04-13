package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 * year类型构建器
 */
public class MySQLYearFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.YEAR;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 4;
    }

}
