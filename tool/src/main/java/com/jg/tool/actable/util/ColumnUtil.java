package com.jg.tool.actable.util;

import cn.hutool.core.util.StrUtil;
import com.jg.tool.actable.annotation.Column;
import com.jg.tool.util.StrTool;

import java.lang.reflect.Field;

/**
 * Column工具类
 */
public class ColumnUtil {

    /**
     * 获取数据库表字段名称
     * @param column
     * @return
     */
    public static String getTableFieldName(final Field field, final Column column) {
        String result = column.name();
        if (StrUtil.isEmpty(result)) {
            result = StrTool.fromHump(field.getName());
        }
        return result;
    }

}
