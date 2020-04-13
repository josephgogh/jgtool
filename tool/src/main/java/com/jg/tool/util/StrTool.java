package com.jg.tool.util;

import cn.hutool.core.util.StrUtil;

/**
 * 字符串工具类
 */
public class StrTool {

    /**
     * 将字符串从驼峰格式转换为_格式
     * @param str   字符串
     * @return  字符串
     */
    public static String fromHump(final String str) {
        if (StrUtil.isEmpty(str)) {
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

}
