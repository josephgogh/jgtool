package com.jg.tool.actable.builder.sqlserver;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.constant.SqlServerFieldType;

/**
 * binary类型构建器
 * @author gaolj
 */
public class SqlServerBinaryFieldBuilder extends AbstractSqlServerFieldBuilder {

    @Override
    protected String getFieldType() {
        return SqlServerFieldType.BINARY;
    }

    @Override
    protected int getFieldLength(Column column) {
        int length = column.length();
        int defaultLength = 50;
        if (length <= 0) {
            length = defaultLength;
        }
        return length;
    }

}
