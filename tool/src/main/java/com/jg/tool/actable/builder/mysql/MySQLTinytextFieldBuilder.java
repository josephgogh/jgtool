package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 *  tinytext类型构建器
 */
public class MySQLTinytextFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.TINYTEXT;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
