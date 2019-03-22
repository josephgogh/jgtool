package com.jg.tool.valid.model;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.Valid;
import com.jg.tool.valid.annotation.NumIn;

public class TestValidNumIn extends AbstractValid implements Valid {

    @NumIn(value = {1, 2, 3})
    private int test1;
    @NumIn(value = {1.1, 2.2, 3.3})
    private double test2;

    public int getTest1() {
        return test1;
    }

    public void setTest1(int test1) {
        this.test1 = test1;
    }

    public double getTest2() {
        return test2;
    }

    public void setTest2(double test2) {
        this.test2 = test2;
    }
}
