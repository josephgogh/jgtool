package com.jg.tool.actable.annotation;

import java.lang.annotation.*;

/**
 * 表示该字段需要自动创建
 * @author gaolj
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Column {

    /**
     * 字段名
     * @return
     */
    String name() default "";

    /**
     * 字段类型
     * @return
     */
    String type() default "";

    /**
     * 字段长度
     * @return
     */
    int length() default 0;

    /**
     * 小数点后面的长度
     * @return
     */
    int decimalLength() default 0;

    /**
     * 是否为null，true：是；false： 否
     * @return
     */
    boolean isNull() default true;

    /**
     * 是否为主键，true：是；false：否
     * @return
     */
    boolean isKey() default false;

    /**
     * 默认值
     * @return
     */
    String defaultValue() default "";
}
