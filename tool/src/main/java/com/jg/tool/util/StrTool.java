package com.jg.tool.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;

/**
 * 字符串工具类
 */
public class StrTool extends StrUtil {

    /**
     * 将字符串从驼峰格式转换为_格式
     * @param str   字符串
     * @return  字符串
     */
    public static String fromHump(final String str) {
        if (isEmpty(str)) {
            return str;
        }
        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (Character.isUpperCase(c) && result.length() > 0) {
                result.append("_");
            }
            result.append(Character.toLowerCase(c));
        }
        return result.toString();
    }

    /**
     * 字符串resource是否包含target
     * @param resource 源字符串
     * @param target 目标字符串
     * @return true：包含；false：不包含
     */
    public static boolean containStr(String resource, String target) {
        return null != resource && resource.contains(target);
    }

    /**
     * Double类型转str
     * @param value 值
     * @return 转换后的值
     */
    public static String doubleToStr(Double value) {
        if (value == null) {
            return "";
        }
        String res = Convert.toStr(value);
        if (res.endsWith(".0")) {
            res = res.substring(0, res.length() - 2);
        }
        return res;
    }

    /**
     * 时间间隔转str显示
     * @param durationTime 时长
     * @return 字符显示
     */
    public static String durationTimeToStr(Long durationTime) {
        return durationTimeToStr(durationTime, true);
    }

    /**
     * 时间间隔转str显示
     * @param durationTime 时长
     * @param ignoreSec 是否忽略秒
     * @return 字符显示
     */
    public static String durationTimeToStr(Long durationTime, boolean ignoreSec) {
        if (durationTime == null || durationTime <= 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        long day = durationTime / 86400000;
        if (day > 0) {
            res.append(day).append("天");
            durationTime = durationTime % 86400000;
        }
        long hour = durationTime / 3600000;
        if (hour > 0) {
            res.append(hour).append("时");
            durationTime = durationTime % 3600000;
        }
        long min = durationTime / 60000;
        if (min > 0) {
            res.append(min).append("分");
            durationTime = durationTime % 60000;
        }
        if (!ignoreSec) {
            long sec = durationTime / 1000;
            if (sec > 0) {
                res.append(sec).append("秒");
            }
        }
        return res.toString();
    }

}
