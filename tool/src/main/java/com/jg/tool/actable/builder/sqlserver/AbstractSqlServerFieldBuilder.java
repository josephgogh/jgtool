package com.jg.tool.actable.builder.sqlserver;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.builder.AbstractFieldBuilder;
import com.jg.tool.actable.constant.MySqlFieldType;
import com.jg.tool.actable.constant.OracleFieldType;
import com.jg.tool.actable.constant.SqlServerFieldType;
import com.jg.tool.actable.db.po.FieldStructure;

import java.lang.reflect.Field;

/**
 * oracle字段构建器
 * @author gaolj
 */
public abstract class AbstractSqlServerFieldBuilder extends AbstractFieldBuilder {

    @Override
    public String buildModify(Field field, Column column, FieldStructure fieldStructure) {
        //这两者等价，不进行修改
        if ("decimal".equals(fieldStructure.getType().toLowerCase()) && this.fieldType.equals(SqlServerFieldType.NUMERIC)) {
            return null;
        }
        return super.buildModify(field, column, fieldStructure);
    }
}
