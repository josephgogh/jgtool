package com.jg.tool.valid.pattern;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.annotation.Pattern;

public class TestPattern extends AbstractValid {

    @Pattern(regexp = "^(.+)@(.+)$",ignoreNull = true)
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
