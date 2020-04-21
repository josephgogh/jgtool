package com.jg.tool.actable.constant;

/**
 * 模式类型
 * @author gaolj
 */
public interface AutoType {

    /**
     * 创建模式
     * 会将配置的表删除，然后根据配置的结构重新建表
     * 该操作会破坏原有数据
     */
    String CREATE = "create";

    /**
     * 插入模式
     * 不修改原有的表结构，
     * 当表中的字段不存在的时候，进行新增
     */
    String INSERT = "insert";

    /**
     * 更新模式
     * 修改原有的表结构，
     * 当表中的字段不存在的时候，进行新增
     * 当表中的字段存在的时候但是字段类型不一致的时候，进行更新
     */
    String UPDATE = "update";

    /**
     * 不进行任何处理
     */
    String NONE = "none";

}
