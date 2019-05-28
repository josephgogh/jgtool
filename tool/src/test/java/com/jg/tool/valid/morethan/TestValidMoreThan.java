package com.jg.tool.valid.morethan;

import com.jg.tool.valid.annotation.MoreThan;

public class TestValidMoreThan {

    @MoreThan(value = 10, ignoreNull = true, message = "异常信息")
    private String test1;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }
}
