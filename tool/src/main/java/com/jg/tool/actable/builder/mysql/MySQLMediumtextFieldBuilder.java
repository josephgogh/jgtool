package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 *  mediumtext类型构建器
 */
public class MySQLMediumtextFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.MEDIUMTEXT;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
