package com.jg.tool.valid.isphonenum;

import com.jg.tool.valid.annotation.IsPhoneNum;

public class TestIsPhoneNum2 {

    @IsPhoneNum(ignoreEmpty = true)
    private String test1;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }
}
