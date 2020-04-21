package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySqlFieldType;

/**
 * date类型构建器
 * @author gaolj
 */
public class MySqlDateFieldBuilder extends MySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySqlFieldType.DATE;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
