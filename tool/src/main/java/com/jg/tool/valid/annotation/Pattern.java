package com.jg.tool.valid.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 正则表达式校验
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface Pattern {

    /**
     * 正则表达式
     */
    String regexp();

    /**
     * 异常信息
     */
    String message() default "{fieldName}参数不符合正则表达式规则{{regexp}}！";

}
