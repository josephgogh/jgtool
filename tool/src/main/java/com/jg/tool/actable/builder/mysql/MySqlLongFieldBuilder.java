package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;

/**
 * long类型构建器
 * @author gaolj
 */
public class MySqlLongFieldBuilder extends AbstractMySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return "int";
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        if (length <= 0 || length > 24) {
            length = 24;
        }
        return length;
    }

    @Override
    protected int getFieldDecimalLength(Column column) {
        return 0;
    }
}
