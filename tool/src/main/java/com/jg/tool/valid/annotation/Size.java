package com.jg.tool.valid.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 参数长度必须在min-max之间
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface Size {

    /**
     * 最小长度
     */
    int min() default 0;

    /**
     * 最大长度
     */
    int max() default Integer.MAX_VALUE;

    /**
     * 当字段为null时，是否忽略校验
     * 默认false：需要校验
     */
    boolean ignoreNull() default false;

    /**
     * 当字段为null或者字段为空字符串时，是否忽略校验
     * 默认false: 需要校验
     */
    boolean ignoreEmpty() default false;

    /**
     * 异常信息
     */
    String message() default "{fieldName}参数长度必须在{min}-{max}之间！";

}
