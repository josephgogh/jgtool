package com.jg.tool.valid.max;

import com.jg.tool.valid.annotation.Max;

public class TestMax {

    @Max(value = 10, ignoreNull = true, message = "异常信息")
    private String test1;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }
}
