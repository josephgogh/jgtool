package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySqlFieldType;

/**
 * tinyint类型构建器
 * @author gaolj
 */
public class MySqlTinyintFieldBuilder extends AbstractMySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySqlFieldType.TINYINT;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        int maxLength = 3;
        if (length <= 0 || length > maxLength) {
            length = maxLength;
        }
        return length;
    }

}
