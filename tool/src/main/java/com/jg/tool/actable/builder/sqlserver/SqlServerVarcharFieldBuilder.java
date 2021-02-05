package com.jg.tool.actable.builder.sqlserver;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.SqlServerFieldType;

/**
 * varchar类型构建器
 * @author gaolj
 */
public class SqlServerVarcharFieldBuilder extends AbstractSqlServerFieldBuilder {

    @Override
    protected String getFieldType() {
        return SqlServerFieldType.VARCHAR;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        int defaultLength = 200;
        if (length <= 0) {
            length = defaultLength;
        }
        return length;
    }

}
