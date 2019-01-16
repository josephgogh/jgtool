package com.jg.tool.valid.model;

import com.jg.tool.valid.AbstractValid;
import com.jg.tool.valid.Valid;
import com.jg.tool.valid.annotation.Empty;
import com.jg.tool.valid.annotation.Null;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class TestValidEmpty extends AbstractValid implements Valid {

    @Empty
    private String test1;
    @Empty(message = "数组必须为空")
    private String[] test2;
    @Empty
    private List<String> test3;
    @Empty
    private Map<String, String> test4;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String[] getTest2() {
        return test2;
    }

    public void setTest2(String[] test2) {
        this.test2 = test2;
    }

    public List<String> getTest3() {
        return test3;
    }

    public void setTest3(List<String> test3) {
        this.test3 = test3;
    }

    public Map<String, String> getTest4() {
        return test4;
    }

    public void setTest4(Map<String, String> test4) {
        this.test4 = test4;
    }
}
