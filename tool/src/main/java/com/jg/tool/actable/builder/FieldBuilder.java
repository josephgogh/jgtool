package com.jg.tool.actable.builder;

import cn.hutool.core.util.StrUtil;
import com.jg.tool.actable.annotation.Column;
import com.jg.tool.actable.db.po.FieldStructure;
import com.jg.tool.actable.util.ColumnUtil;

import java.lang.reflect.Field;

/**
 * 字段构建抽象类
 */
public abstract class FieldBuilder {

    protected String fieldType;    //字段类型

    public FieldBuilder() {
        this.fieldType = this.getFieldType();
    }

    /**
     * 获取字段类型
     * @return
     */
    protected abstract String getFieldType();

    /**
     * 构建字段
     * @param field
     * @param column
     * @return
     */
    public String build(final Field field, final Column column) {
        StringBuilder result = new StringBuilder();
        String fieldName = ColumnUtil.getTableFieldName(field, column);
        result.append(fieldName).append(" ");
        result.append(this.fieldType);
        int length = this.getFieldLength(column);
        if ( length > 0) {  //长度大于0，则添加字段长度
            result.append("(").append(length);
            int decimalLength = this.getFieldDecimalLength(column);
            if (decimalLength > 0){
                result.append(",").append(decimalLength);
            }
            result.append(")").append(" ");
        }
        if (!column.isNull()) { //判断是否不能为空
            result.append(" not null ");
        }
        if (column.isKey()) {   //判断是否为主键
            result.append(" primary key ");
        }
        if (StrUtil.isNotEmpty(column.defaultValue())) {    //默认值不为空
            result.append(" default '").append(column.defaultValue()).append("' ");
        }
        return result.toString();
    }

    /**
     * 构建字段
     * 模式：修改
     * @param field
     * @param column
     * @param fieldStructure
     * @return
     */
    public String buildModify(Field field, Column column, FieldStructure fieldStructure) {
        if (this.fieldType.equals(fieldStructure.getType().toLowerCase())) {    //类型相等，不修改
            return null;
        }
        StringBuilder result = new StringBuilder();
        String fieldName = ColumnUtil.getTableFieldName(field, column);
        result.append(fieldName).append(" ");
        result.append(this.fieldType);
        int length = this.getFieldLength(column);
        if ( length > 0) {  //长度大于0，则添加字段长度
            result.append("(").append(length);
            int decimalLength = this.getFieldDecimalLength(column);
            if (decimalLength > 0){
                result.append(",").append(decimalLength);
            }
            result.append(")").append(" ");
        }
        if (column.isNull() && !fieldStructure.isNull()) { //判断字段类型可以为空的时候，但是原字段不为空，则设置为空
            result.append(" null ");
        } else if (!column.isNull() && fieldStructure.isNull()) {  //判断字段类型不为空的时候，且原字段为空，则设置不为空
            result.append(" not null ");
        }
        if (column.isKey() && !fieldStructure.isKey()) {   //判断是否为主键,原自动不能为主键
            result.append(" primary key ");
        }
        if (StrUtil.isNotEmpty(column.defaultValue())) {    //默认值不为空
            result.append(" default '").append(column.defaultValue()).append("' ");
        }
        return result.toString();
    }

    /**
     * 构建字段
     * 模式：新增
     * @param field
     * @param column
     * @return
     */
    public String buildAdd(Field field, Column column) {
        return build(field, column);
    }


    /**
     * 构建字段
     * 模式：创建
     * @param field
     * @param column
     * @return
     */
    public String buildCreate(Field field, Column column) {
        return build(field, column);
    }

    /**
     * 获取字段长度
     * @param column
     * @return
     */
    protected int getFieldLength(final Column column) {
        return column.length();
    }

    /**
     * 获取字段小数点后的长度
     * @param column
     * @return
     */
    protected int getFieldDecimalLength(final Column column) {
        return column.decimalLength();
    }

}
