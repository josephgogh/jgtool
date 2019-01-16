package com.jg.tool.valid.model;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.Valid;
import com.jg.tool.valid.annotation.NotNull;
import com.jg.tool.valid.annotation.Null;

public class TestValidNull extends AbstractValid implements Valid {

    @Null
    private String test1;
    @Null(message = "测试2必须为空！")
    private String test2;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }
}
