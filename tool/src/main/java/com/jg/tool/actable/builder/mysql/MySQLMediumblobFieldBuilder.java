package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySQLFieldType;

/**
 *  mediumblob类型构建器
 */
public class MySQLMediumblobFieldBuilder extends MySQLFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySQLFieldType.MEDIUMBLOB;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
