package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.builder.FieldBuilder;
import com.jg.tool.actable.constant.MySQLFieldType;
import com.jg.tool.actable.db.po.FieldStructure;

import java.lang.reflect.Field;

/**
 * mysql字段构建器
 */
public abstract class MySQLFieldBuilder extends FieldBuilder {

    @Override
    public String buildModify(Field field, Column column, FieldStructure fieldStructure) {
        //这两者等价，不进行修改
        if ("decimal".equals(fieldStructure.getType().toLowerCase()) && this.fieldType.equals(MySQLFieldType.NUMERIC)) {
            return null;
        }
        return super.buildModify(field, column, fieldStructure);
    }
}
