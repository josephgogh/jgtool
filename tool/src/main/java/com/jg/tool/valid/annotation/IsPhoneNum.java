package com.jg.tool.valid.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 参数为电话号码校验
 * null、""、length=0、size=0
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface IsPhoneNum {

    /**
     *  是否忽略不校验空字符串
     *  默认为不忽略
     */
    boolean ignoreEmpty() default false;

    /**
     * 异常信息
     */
    String message() default "{fieldName}参数必须为电话号码！";

}
