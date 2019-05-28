package com.jg.tool.valid.size;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.annotation.Size;

public class TestSize1 extends AbstractValid {

    @Size(min = 1, max = 10, ignoreEmpty = true)
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
