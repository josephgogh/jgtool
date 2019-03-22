package com.jg.tool.valid.model;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.Valid;
import com.jg.tool.valid.annotation.NumIn;
import com.jg.tool.valid.annotation.StrIn;

public class TestValidStrIn extends AbstractValid implements Valid {

    @StrIn(value = {"1", "2", "3"})
    private String test1;
    @StrIn(value = {"1.1", "2.2", "3.3"})
    private String test2;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }
}
