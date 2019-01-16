package com.jg.tool.valid.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 参数必须大等于校验
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface Min {

    /**
     * 最小值
     */
    double value();

    /**
     * 异常信息
     */
    String message() default "{fieldName}参数必须大等于{min}！";

}
