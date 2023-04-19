package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;

/**
 * datetime类型构建器
 * @author gaolj
 */
public class MySqlDatetimeFieldBuilder extends AbstractMySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return "datetime";
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
