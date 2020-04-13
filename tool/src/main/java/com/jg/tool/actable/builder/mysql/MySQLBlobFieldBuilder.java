package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 *  blob类型构建器
 */
public class MySQLBlobFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.BLOB;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
