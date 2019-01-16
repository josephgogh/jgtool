package com.jg.tool.valid.model;

import com.jg.tool.valid.annotation.Min;

public class TestValidMin {

    @Min(10)
    private String test1;
    @Min(value = 20, message = "测试2必须大于20")
    private int test2;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public int getTest2() {
        return test2;
    }

    public void setTest2(int test2) {
        this.test2 = test2;
    }
}
