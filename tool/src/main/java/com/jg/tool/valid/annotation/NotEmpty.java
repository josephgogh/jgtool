package com.jg.tool.valid.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 参数为不为空校验
 * 不等于null、""、length=0、size=0
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface NotEmpty {

    /**
     * 异常信息
     */
    String message() default "{fieldName}参数不能为空！";

}
