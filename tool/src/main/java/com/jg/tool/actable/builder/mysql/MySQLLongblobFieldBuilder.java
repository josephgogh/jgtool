package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 *  longblob类型构建器
 */
public class MySQLLongblobFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.LONGBLOB;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
