package com.jg.tool.valid.isnumber;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.annotation.Number;

public class TestIsNumber extends AbstractValid {

    @Number(ignoreNull = true)
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
