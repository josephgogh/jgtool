package com.jg.tool.valid.strin;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.annotation.StrIn;

public class TestStrIn extends AbstractValid {

    @StrIn(value = {"1", "2", "3"}, ignoreNull = true)
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
