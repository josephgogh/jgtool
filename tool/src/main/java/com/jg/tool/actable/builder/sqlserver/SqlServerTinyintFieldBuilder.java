package com.jg.tool.actable.builder.sqlserver;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.SqlServerFieldType;

/**
 * tinyint类型构建器
 * @author gaolj
 */
public class SqlServerTinyintFieldBuilder extends AbstractSqlServerFieldBuilder {

    @Override
    protected String getFieldType() {
        return SqlServerFieldType.TINYINT;
    }

    @Override
    protected int getFieldLength(Column column) {
        return 0;
    }

}
