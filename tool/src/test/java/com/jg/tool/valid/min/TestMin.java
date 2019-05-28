package com.jg.tool.valid.min;

import com.jg.tool.valid.annotation.Min;

public class TestMin {

    @Min(value = 10, ignoreNull = true)
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
