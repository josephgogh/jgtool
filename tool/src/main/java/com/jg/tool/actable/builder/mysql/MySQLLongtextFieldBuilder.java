package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 *  longtext类型构建器
 */
public class MySQLLongtextFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.LONGTEXT;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
