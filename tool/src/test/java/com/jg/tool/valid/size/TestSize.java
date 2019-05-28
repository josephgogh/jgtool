package com.jg.tool.valid.size;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.annotation.Size;

public class TestSize extends AbstractValid {

    @Size(min = 1, max = 10, ignoreNull = true)
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
