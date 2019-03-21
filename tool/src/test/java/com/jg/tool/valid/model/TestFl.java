package com.jg.tool.valid.model;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.Valid;
import com.jg.tool.valid.annotation.NotEmpty;

public class TestFl extends AbstractValid implements Valid {

    @NotEmpty(message = "test不能为空！")
    protected String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
