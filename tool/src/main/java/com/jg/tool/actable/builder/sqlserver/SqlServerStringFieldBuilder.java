package com.jg.tool.actable.builder.sqlserver;

import com.jg.tool.actable.annotation.Column;

/**
 * varchar类型构建器
 * @author gaolj
 */
public class SqlServerStringFieldBuilder extends AbstractSqlServerFieldBuilder {

    @Override
    protected String getFieldType() {
        return "varchar";
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        if (length <= 0 || length > 4000) {
            length = 400;
        }
        return length;
    }

}
