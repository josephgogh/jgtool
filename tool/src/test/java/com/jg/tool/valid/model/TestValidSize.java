package com.jg.tool.valid.model;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.Valid;
import com.jg.tool.valid.annotation.Size;

public class TestValidSize extends AbstractValid implements Valid {

    @Size(max = 10)
    private String test1;
    @Size(min = 1, max = 10, message = "测试参数2长度必须在1-10之间")
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
