package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySqlFieldType;

/**
 *  mediumtext类型构建器
 *  @author gaolj
 */
public class MySqlMediumtextFieldBuilder extends AbstractMySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySqlFieldType.MEDIUMTEXT;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
