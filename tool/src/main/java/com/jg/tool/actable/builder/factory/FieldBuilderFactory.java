package com.jg.tool.actable.builder.factory;

import cn.hutool.core.util.StrUtil;
import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.builder.FieldBuilder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class FieldBuilderFactory {

    protected Map<String, FieldBuilder> fieldBuilderMap = new HashMap<>();

    /**
     * 获取字段构建器
     * @param column
     * @return
     */
    public FieldBuilder getFieldBuilder(final Field field, final Column column) {
        String type = column.type();
        if (StrUtil.isEmpty(type)) {
            type = field.getType().getName();
        }
        return this.fieldBuilderMap.get(type);
    }

    /**
     * 添加
     * @param type
     * @param fieldBuilder
     */
    protected void add(String type, FieldBuilder fieldBuilder) {
        this.fieldBuilderMap.put(type, fieldBuilder);
    }

}
