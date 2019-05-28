package com.jg.tool.valid.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 参数必须在某几个值之类
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface NumIn {

    /**
     * 值数组
     */
    double[] value();

    /**
     * 当字段为null时，是否忽略校验
     * 默认false：需要校验
     */
    boolean ignoreNull() default false;

    /**
     * 异常信息
     */
    String message() default "{fieldName}参数必须在值{value}中！";

}
