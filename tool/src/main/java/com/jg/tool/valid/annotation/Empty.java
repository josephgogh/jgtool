package com.jg.tool.valid.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 参数为空校验
 * null、""、length=0、size=0
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface Empty {

    /**
     * 异常信息
     */
    String message() default "{fieldName}参数必须为空！";

}
