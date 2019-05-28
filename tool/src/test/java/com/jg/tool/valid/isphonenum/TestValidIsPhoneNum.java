package com.jg.tool.valid.isphonenum;

import com.jg.tool.TestImpl;
import com.jg.tool.valid.util.ValidUtil;
import org.junit.Test;

public class TestValidIsPhoneNum extends TestImpl {

    @Test
    public void testIsPhoneNum() {
        TestIsPhoneNum testIsPhoneNum = new TestIsPhoneNum();
        expectedException.expectMessage("test1参数必须为电话号码！");
        ValidUtil.valid(testIsPhoneNum);
    }

    @Test
    public void testIsPhoneNum2() {
        TestIsPhoneNum testIsPhoneNum = new TestIsPhoneNum();
        testIsPhoneNum.setTest1("123123");
        expectedException.expectMessage("test1参数必须为电话号码！");
        ValidUtil.valid(testIsPhoneNum);
    }

    @Test
    public void testIsPhoneNum3() {
        TestIsPhoneNum testIsPhoneNum = new TestIsPhoneNum();
        testIsPhoneNum.setTest1("12345678912");
        expectedException.expectMessage("test1参数必须为电话号码！");
        ValidUtil.valid(testIsPhoneNum);
    }

    @Test
    public void testIsPhoneNum4() {
        TestIsPhoneNum testIsPhoneNum = new TestIsPhoneNum();
        testIsPhoneNum.setTest1("18704090123");
        ValidUtil.valid(testIsPhoneNum);
    }

    @Test
    public void testIsPhoneNum5() {
        TestIsPhoneNum testIsPhoneNum = new TestIsPhoneNum();
        testIsPhoneNum.setTest1("0591-85738511");
        ValidUtil.valid(testIsPhoneNum);
    }

    @Test
    public void testIsPhoneNum6() {
        TestIsPhoneNum testIsPhoneNum = new TestIsPhoneNum();
        testIsPhoneNum.setTest1("051-85738511");
        ValidUtil.valid(testIsPhoneNum);
    }

    @Test
    public void testIsPhoneNum7() {
        TestIsPhoneNum2 testIsPhoneNum = new TestIsPhoneNum2();
        ValidUtil.valid(testIsPhoneNum);
    }

}
