package com.jg.tool.valid.model;

import com.jg.tool.valid.annotation.NotEmpty;

public class TestZl extends TestFl {

    @NotEmpty(message = "test1不能为空！")
    protected String test1;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }
}
