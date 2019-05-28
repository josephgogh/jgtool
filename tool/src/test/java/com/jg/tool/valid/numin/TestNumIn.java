package com.jg.tool.valid.numin;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.annotation.NumIn;

public class TestNumIn extends AbstractValid {

    @NumIn(value = {1, 2,3}, ignoreNull = true)
    private Double test;

    public Double getTest() {
        return test;
    }

    public void setTest(Double test) {
        this.test = test;
    }
}
