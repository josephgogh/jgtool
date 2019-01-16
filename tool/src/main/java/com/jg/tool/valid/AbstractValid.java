package com.jg.tool.valid;

import com.jg.tool.valid.util.ValidUtil;

/**
 * 校验统一实现抽象类
 */
public abstract class AbstractValid implements Valid {

    /**
     * 进行字段校验
     */
    @Override
    public void valid() {
        ValidUtil.valid(this);
    }

}
