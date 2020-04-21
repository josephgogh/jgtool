package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySqlFieldType;

/**
 * bigint类型构建器
 * @author gaolj
 */
public class MySqlBigintFieldBuilder extends MySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySqlFieldType.BIGINT;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        int maxLength = 20;
        if (length <= 0 || length > maxLength) {
            length = maxLength;
        }
        return length;
    }

}
