package com.jg.tool.actable.builder.oracle;

import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.builder.FieldBuilder;
import com.jg.tool.actable.constant.OracleFieldType;
import com.jg.tool.actable.db.po.FieldStructure;

import java.lang.reflect.Field;

/**
 * oracle字段构建器
 */
public abstract class OracleFieldBuilder extends FieldBuilder {

    @Override
    public String buildModify(Field field, Column column, FieldStructure fieldStructure) {
        //类型为number类型，且小数点位数等于0，则等价于integer
        if ("NUMBER".equals(fieldStructure.getType().toUpperCase())
                && fieldStructure.getDecimalLength() == 0
                && this.fieldType.equals(OracleFieldType.INTEGER)) {
            return null;
        }
        return super.buildModify(field, column, fieldStructure);
    }
}
