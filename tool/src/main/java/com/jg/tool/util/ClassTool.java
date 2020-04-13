package com.jg.tool.util;

import cn.hutool.core.lang.Filter;
import com.jg.tool.empty.EmptyObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类工具
 */
public class ClassTool {

    /**
     * 获取类的所有字段（包括父类）
     * @param cls
     * @return
     */
    public static List<Field> getFieldsContainSuper(final Class<?> cls) {
        List<Field> result = new ArrayList<>();
        Class clz = cls;
        while (clz != null) {
            result.addAll(getFields(clz));
            clz = clz.getSuperclass();
        }
        return result;
    }

    /**
     * 获取类的所有字段（不包括父类）
     * @param cls
     * @return
     */
    public static List<Field> getFields(final Class<?> cls) {
        return Arrays.asList(cls.getDeclaredFields());
    }

    /**
     * 获取类的所有字段（包括父类）
     * @param cls   类
     * @param filter    过滤条件
     * @return
     */
    public static List<Field> getFieldsContainSuper(final Class<?> cls, Filter<Field> filter) {
        return filterFields(getFieldsContainSuper(cls), filter);
    }

    /**
     * 获取类的所有字段（不包括父类）
     * @param cls   类
     * @param filter    过滤条件
     * @return
     */
    public static List<Field> getFields(final Class<?> cls, Filter<Field> filter) {
        return filterFields(getFields(cls), filter);
    }

    /**
     * 过滤字段
     * @param fieldList
     * @param filter
     * @return
     */
    public static List<Field> filterFields(final List<Field> fieldList, Filter<Field> filter) {
        List<Field> result = new ArrayList<>();
        for (Field field : EmptyObject.list(fieldList)) {
            if (filter.accept(field)) {
                result.add(field);
            }
        }
        return result;
    }

}
