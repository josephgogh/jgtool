package com.jg.tool.valid.model;

import com.jg.tool.valid.annotation.NotEmpty;

public class TestZl2 extends TestZl {

    @NotEmpty(message = "test2不能为空！")
    protected String test2;

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }
}
