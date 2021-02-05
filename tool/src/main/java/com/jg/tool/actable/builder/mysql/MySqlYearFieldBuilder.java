package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.MySqlFieldType;

/**
 * year类型构建器
 * @author gaolj
 */
public class MySqlYearFieldBuilder extends AbstractMySqlFieldBuilder {

    @Override
    protected String getFieldType() {
        return MySqlFieldType.YEAR;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 4;
    }

}
