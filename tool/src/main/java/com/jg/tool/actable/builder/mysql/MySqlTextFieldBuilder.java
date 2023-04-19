package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;

/**
 *  text类型构建器
 *  @author gaolj
 */
public class MySqlTextFieldBuilder extends AbstractMySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return "longtext";
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
