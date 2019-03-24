package com.jg.tool.valid.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.jg.tool.exception.ValidationException;
import com.jg.tool.valid.annotation.*;
import com.jg.tool.valid.annotation.Number;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 校验工具类
 */
public class ValidUtil {

    private ValidUtil() {
        throw new ValidationException("该对象为工具类对象，无法被实例化");
    }

    /**
     * 校验方法
     * @param object 校验对象
     */
    public static void valid(Object object) {
        for (Field field : getAllFields(object)) {
            validField(object, field);
        }
    }

    /**
     * 获取所有字段
     * @param object    对象
     * @return  字段集合
     */
    private static List<Field> getAllFields(Object object) {
        List<Field> result = new ArrayList<>();
        Class cls = object.getClass();
        while (cls != null) {
            result.addAll(Arrays.asList(cls.getDeclaredFields()));
            cls = cls.getSuperclass();
        }
        return result;
    }

    /**
     * 校验字段
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validField(Object object, Field field) {
        if (field.isAnnotationPresent(Null.class)) {
            validNull(object, field);
        }
        if (field.isAnnotationPresent(NotNull.class)) {
            validNotNull(object, field);
        }
        if (field.isAnnotationPresent(Empty.class)) {
            validEmpty(object, field);
        }
        if (field.isAnnotationPresent(NotEmpty.class)) {
            validNotEmpty(object, field);
        }
        if (field.isAnnotationPresent(Number.class)) {
            validNumber(object, field);
        }
        if (field.isAnnotationPresent(Min.class)) {
            validMin(object, field);
        }
        if (field.isAnnotationPresent(MoreThan.class)) {
            validMoreThan(object, field);
        }
        if (field.isAnnotationPresent(Max.class)) {
            validMax(object, field);
        }
        if (field.isAnnotationPresent(LessThan.class)) {
            validLessThan(object, field);
        }
        if (field.isAnnotationPresent(Size.class)) {
            validSize(object, field);
        }
        if (field.isAnnotationPresent(Pattern.class)) {
            validPattern(object, field);
        }
        if (field.isAnnotationPresent(NumIn.class)) {
            validNumIn(object, field);
        }
        if (field.isAnnotationPresent(StrIn.class)) {
            validStrIn(object, field);
        }
    }

    /**
     * 校验数值是否在规定中
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validStrIn(Object object, Field field) {
        StrIn annotation = field.getAnnotation(StrIn.class);
        String[] value = annotation.value();
        Object result = getResult(object, field);
        if (result != null) {
            String sResult = Convert.toStr(result);
            for (String s : value) {
                if (sResult.equals(s)) {
                    return ;
                }
            }
        }
        StringBuilder valueMsg = new StringBuilder("{");
        for (String s : value) {
            if (valueMsg.toString().equals("{")) {
                valueMsg.append(s);
            } else {
                valueMsg.append(",").append(s);
            }
        }
        valueMsg.append("}");
        String message = annotation.message()
                .replace("{fieldName}", field.getName())
                .replace("{value}", valueMsg.toString());
        throw new ValidationException(message);
    }

    /**
     * 校验数值是否在规定中
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validNumIn(Object object, Field field) {
        NumIn annotation = field.getAnnotation(NumIn.class);
        double[] value = annotation.value();
        Object result = getResult(object, field);
        if (result != null) {
            double dResult = Convert.toDouble(result);
            for (double v : value) {
                if (dResult == v) {
                    return  ;
                }
            }
        }
        StringBuilder valueMsg = new StringBuilder("{");
        for (double v : value) {
            String vs = v+"";
            if (vs.endsWith(".0")) {
                vs = StrUtil.sub(vs, 0, -2);
            }
            if (valueMsg.toString().equals("{")) {
                valueMsg.append(vs);
            } else {
                valueMsg.append(",").append(vs);
            }
        }
        valueMsg.append("}");
        String message = annotation.message()
                .replace("{fieldName}", field.getName())
                .replace("{value}", valueMsg.toString());
        throw new ValidationException(message);
    }

    /**
     * 校验正则表达式
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validPattern(Object object, Field field) {
        Pattern annotation = field.getAnnotation(Pattern.class);
        String regexp = annotation.regexp();
        Object result = getResult(object, field);
        if (result == null || !java.util.regex.Pattern.matches(regexp, result.toString())) {
            String message = annotation.message()
                    .replace("{fieldName}", field.getName())
                    .replace("{regexp}", regexp);
            throw new ValidationException(message);
        }
    }

    /**
     * 校验参数长度
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validSize(Object object, Field field) {
        Size annotation = field.getAnnotation(Size.class);
        int min = annotation.min();
        int max = annotation.max();
        Object result = getResult(object, field);
        String resultStr = StrUtil.toString(result);
        if ((result == null && min > 0) || resultStr.length() < min || resultStr.length() > max) {
            String message = annotation.message()
                    .replace("{fieldName}", field.getName())
                    .replace("{min}", min + "")
                    .replace("{max}", max + "");
            throw new ValidationException(message);
        }
    }


    /**
     * 校验数字小等于
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validMax(Object object, Field field) {
        Max annotation =  field.getAnnotation(Max.class);
        Object result = getResult(object, field);
        Double value = Convert.toDouble(result);
        double max = annotation.value();
        if (value == null || value > max) {
            String minStr = max + "";
            if (minStr.endsWith(".0")) {
                minStr = StrUtil.sub(minStr, 0, -2);
            }
            String message = annotation.message()
                    .replace("{fieldName}", field.getName())
                    .replace("{max}", minStr);
            throw new ValidationException(message);
        }
    }

    /**
     * 校验数字小于
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validLessThan(Object object, Field field) {
        LessThan annotation =  field.getAnnotation(LessThan.class);
        Object result = getResult(object, field);
        Double value = Convert.toDouble(result);
        double max = annotation.value();
        if (value == null || value >= max) {
            String minStr = max + "";
            if (minStr.endsWith(".0")) {
                minStr = StrUtil.sub(minStr, 0, -2);
            }
            String message = annotation.message()
                    .replace("{fieldName}", field.getName())
                    .replace("{max}", minStr);
            throw new ValidationException(message);
        }
    }

    /**
     * 校验数字大等于
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validMin(Object object, Field field) {
        Min annotation =  field.getAnnotation(Min.class);
        Object result = getResult(object, field);
        Double value = Convert.toDouble(result);
        double min = annotation.value();
        if (value == null || value < min) {
            String minStr = min + "";
            if (minStr.endsWith(".0")) {
                minStr = StrUtil.sub(minStr, 0, -2);
            }
            String message = annotation.message()
                    .replace("{fieldName}", field.getName())
                    .replace("{min}", minStr);
            throw new ValidationException(message);
        }
    }

    /**
     * 校验数字大于
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validMoreThan(Object object, Field field) {
        MoreThan annotation =  field.getAnnotation(MoreThan.class);
        Object result = getResult(object, field);
        Double value = Convert.toDouble(result);
        double min = annotation.value();
        if (value == null || value <= min) {
            String minStr = min + "";
            if (minStr.endsWith(".0")) {
                minStr = StrUtil.sub(minStr, 0, -2);
            }
            String message = annotation.message()
                    .replace("{fieldName}", field.getName())
                    .replace("{min}", minStr);
            throw new ValidationException(message);
        }
    }

    /**
     * 校验数字格式字段
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validNumber(Object object, Field field) {
        Number numberAnnotation =  field.getAnnotation(Number.class);
        Object result = getResult(object, field);
        if (result == null) {
            return ;
        }
        Double value = Convert.toDouble(result);
        if (value == null) {
            String message = numberAnnotation.message()
                    .replace("{fieldName}", field.getName());
            throw new ValidationException(message);
        }
    }

    /**
     * 校验对象为空
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validEmpty(Object object, Field field) {
        Object result = getResult(object, field);
        if (!isEmpty(result)) {
            String message = field.getAnnotation(Empty.class).message()
                    .replace("{fieldName}", field.getName());
            throw new ValidationException(message);
        }
    }

    /**
     * 校验参数不能为空
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validNotEmpty(Object object, Field field) {
        Object result = getResult(object, field);
        if (isEmpty(result)) {
            String message = field.getAnnotation(NotEmpty.class).message()
                    .replace("{fieldName}", field.getName());
            throw new ValidationException(message);
        }
    }

    private static boolean isEmpty(Object result) {
        if (result == null) {
            return true;
        }
        if (result instanceof Object[]) {   //对象为数组类型时
            return ((Object[]) result).length == 0;
        } else if (result instanceof List) {    //对象为List类型时
            return ((List) result).size() == 0;
        } else if (result instanceof Map) { //对象为Map类型时
            return ((Map) result).size() == 0;
        } else {
            return StrUtil.toString(result).length() == 0;
        }
    }


    /**
     * 校验必须为空字段
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validNull(Object object, Field field) {
        Object result = getResult(object, field);
        if (result != null) {
            String message = field.getAnnotation(Null.class).message()
                    .replace("{fieldName}", field.getName());
            throw new ValidationException(message);
        }
    }

    /**
     * 校验不为空字段
     * @param object    校验对象
     * @param field 校验字段
     */
    private static void validNotNull(Object object, Field field) {
        Object result = getResult(object, field);
        if (result == null) {
            String message = field.getAnnotation(NotNull.class).message()
                    .replace("{fieldName}", field.getName());
            throw new ValidationException(message);
        }
    }

    /**
     * 获取字段值
     * @param object    校验对象
     * @param field 校验字段
     */
    private static Object getResult(Object object, Field field) {
        Object result;
        try {
            Method method = object.getClass().getMethod("get" + StrUtil.upperFirst(field.getName()));
            if (method == null) {
                method = object.getClass().getMethod("get" + field.getName());
            }
            result = method.invoke(object);
        } catch (Exception e) {
            throw new ValidationException(e);
        }
        return result;
    }

    /**
     * 校验参数不能为null
     * @param obj   校验对象
     * @param errorMsg  错误信息
     */
    public static void notNull(Object obj, String errorMsg) {
        if (obj == null) {
            throw new ValidationException(errorMsg);
        }
    }

    /**
     * 校验参数不能为空
     * @param obj   校验对象
     * @param errorMsg  错误信息
     */
    public static void notEmpty(Object obj, String errorMsg) {
        if (obj == null) {
            throw new ValidationException(errorMsg);
        }
        String strObj = StrUtil.toString(obj);
        if (StrUtil.isEmpty(strObj)) {
            throw new ValidationException(errorMsg);
        }
    }
}
