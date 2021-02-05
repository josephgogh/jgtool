package com.jg.tool.actable.builder.mysql;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.builder.AbstractFieldBuilder;
import com.jg.tool.actable.constant.MySqlFieldType;
import com.jg.tool.actable.db.po.FieldStructure;

import java.lang.reflect.Field;

/**
 * mysql字段构建器
 * @author gaolj
 */
public abstract class AbstractMySqlFieldBuilder extends AbstractFieldBuilder {

    @Override
    public String buildModify(Field field, Column column, FieldStructure fieldStructure) {
        //这两者等价，不进行修改
        if ("decimal".equals(fieldStructure.getType().toLowerCase()) && this.fieldType.equals(MySqlFieldType.NUMERIC)) {
            return null;
        }
        return super.buildModify(field, column, fieldStructure);
    }
}
