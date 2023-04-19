package com.jg.tool.actable.builder.sqlserver;

import com.jg.tool.actable.annotation.Column;

/**
 * int类型构建器
 * @author gaolj
 */
public class SqlServerLongFieldBuilder extends AbstractSqlServerFieldBuilder {

    @Override
    protected String getFieldType() {
        return "int";
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
