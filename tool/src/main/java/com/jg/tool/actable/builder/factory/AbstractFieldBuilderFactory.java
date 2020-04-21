package com.jg.tool.actable.builder.factory;

import cn.hutool.core.util.StrUtil;
import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.builder.AbstractFieldBuilder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 字段构建器工厂
 * @author gaolj
 */
public abstract class AbstractFieldBuilderFactory {

    protected Map<String, AbstractFieldBuilder> fieldBuilderMap = new HashMap<>();

    /**
     * 获取字段构建器
     * @param column
     * @return
     */
    public AbstractFieldBuilder getFieldBuilder(final Field field, final Column column) {
        String type = column.type();
        if (StrUtil.isEmpty(type)) {
            type = field.getType().getName();
        }
        return this.fieldBuilderMap.get(type);
    }

    /**
     * 添加
     * @param type
     * @param abstractFieldBuilder
     */
    protected void add(String type, AbstractFieldBuilder abstractFieldBuilder) {
        this.fieldBuilderMap.put(type, abstractFieldBuilder);
    }

}
