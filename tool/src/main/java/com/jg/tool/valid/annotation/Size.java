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
     * 异常信息
     */
    String message() default "{fieldName}参数长度必须在{min}-{max}之间！";

}
