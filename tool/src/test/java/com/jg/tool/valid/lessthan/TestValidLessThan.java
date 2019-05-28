package com.jg.tool.valid.lessthan;

import com.jg.tool.valid.annotation.LessThan;

public class TestValidLessThan {

    @LessThan(value = 10, ignoreNull = true, message = "异常信息")
    private String test1;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }
}
