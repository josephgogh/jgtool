package com.jg.tool.valid.model;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.Valid;
import com.jg.tool.valid.annotation.Pattern;
import com.jg.tool.valid.annotation.Size;

public class TestValidPattern extends AbstractValid implements Valid {

    @Pattern(regexp = "^(.+)@(.+)$")
    private String test1;

    @Pattern(regexp = "^(.+)@(.+)$",message = "邮箱的格式不合法")
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
