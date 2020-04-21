package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySqlFieldType;

/**
 * datetime类型构建器
 * @author gaolj
 */
public class MySqlDatetimeFieldBuilder extends MySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySqlFieldType.DATETIME;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
