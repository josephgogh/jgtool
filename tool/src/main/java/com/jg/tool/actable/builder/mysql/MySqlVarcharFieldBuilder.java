package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySqlFieldType;

/**
 * varchar类型构建器
 * @author gaolj
 */
public class MySqlVarcharFieldBuilder extends MySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySqlFieldType.VARCHAR;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        if (length <= 0) {
            //默认长度255
            length = 255;
        }
        int maxLength = 21845;
        if (length > maxLength) {
            length = maxLength;
        }
        return length;
    }

}
