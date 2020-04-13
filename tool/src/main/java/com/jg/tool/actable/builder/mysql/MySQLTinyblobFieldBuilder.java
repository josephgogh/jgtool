package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 *  tinyblob类型构建器
 */
public class MySQLTinyblobFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.TINYBLOB;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
