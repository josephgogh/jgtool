package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySqlFieldType;

/**
 * char类型构建器
 * @author gaolj
 */
public class MySqlCharFieldBuilder extends MySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySqlFieldType.CHAR;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        int maxLength = 255;
        if (length <= 0 || length > maxLength) {
            length = maxLength;
        }
        return length;
    }

}
