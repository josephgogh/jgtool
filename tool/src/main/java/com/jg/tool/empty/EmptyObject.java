package com.jg.tool.empty;

import com.jg.tool.exception.EmptyObjectException;

import java.util.*;

/**
 * 空对象工具
 */
public class EmptyObject {

    private EmptyObject() {
        throw new RuntimeException("当前类无法被实例化！");
    }

    /**
     * 如果obj对象为null，则返回defualtObj，否则返回obj
     * @param obj      obj
     * @param defaultObj    默认对象
     * @param <T>     T
     * @return  对象
     */
    public static <T> T object(T obj, T defaultObj) {
        if (null == obj) {
            if (null == defaultObj) {
                throw new EmptyObjectException("默认对象不能为null！");
            }
            return defaultObj;
        }
        return obj;
    }

    /**
     * 如果list为null，则创建一个空的list对象，如果不为空，则原样返回
     * @param list  list
     * @param <T>   T
     * @return  list对象
     */
    public static <T> List<T> list(List<T> list) {
        if (null == list) {
            list = new ArrayList<>();
        }
        return list;
    }

    /**
     * 如果set为null，则创建一个空的set对象，如果set不为空，则原样返回
     * @param set   set
     * @param <T>   T
     * @return  set对象
     */
    public static <T> Set<T> set(Set<T> set) {
        if (null == set) {
            set = new HashSet<>();
        }
        return set;
    }

    /**
     * 如果map为null，则创建一个空的map集合对象，如果不为空，则原样返回
     * @param map   map
     * @param <K>   K
     * @param <T>   T
     * @return  map对象
     */
    public static <K, T> Map<K, T> map(Map<K, T> map) {
        if (null == map) {
            map = new HashMap<>();
        }
        return map;
    }

}
