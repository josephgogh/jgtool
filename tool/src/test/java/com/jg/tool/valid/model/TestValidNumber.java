package com.jg.tool.valid.model;

import com.jg.tool.valid.annotation.Number;

public class TestValidNumber {

    @Number
    private String test1;
    @Number(message = "测试2必须为数字类型！")
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
