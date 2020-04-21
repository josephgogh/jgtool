package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySqlFieldType;

/**
 *  mediumblob类型构建器
 *  @author gaolj
 */
public class MySqlMediumblobFieldBuilder extends MySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySqlFieldType.MEDIUMBLOB;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
