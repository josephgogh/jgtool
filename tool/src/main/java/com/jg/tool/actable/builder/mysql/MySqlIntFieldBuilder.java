package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySqlFieldType;

/**
 * int类型构建器
 * @author gaolj
 */
public class MySqlIntFieldBuilder extends AbstractMySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySqlFieldType.INT;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        int maxLength = 11;
        if (length <= 0 || length > maxLength) {
            length = maxLength;
        }
        return length;
    }

}
