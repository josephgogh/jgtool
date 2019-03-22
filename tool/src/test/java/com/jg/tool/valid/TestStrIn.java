package com.jg.tool.valid;

import com.jg.tool.TestImpl;
import com.jg.tool.valid.model.TestValidNumIn;
import com.jg.tool.valid.model.TestValidStrIn;
import com.jg.tool.valid.util.ValidUtil;
import org.junit.Test;

public class TestStrIn extends TestImpl {

    @Test
    public void test1() {
        TestValidStrIn testValidStrIn = new TestValidStrIn();
        expectedException.expectMessage("test1参数必须在值{1,2,3}中！");
        ValidUtil.valid(testValidStrIn);
    }
    @Test
    public void test2() {
        TestValidStrIn testValidStrIn = new TestValidStrIn();
        testValidStrIn.setTest1("0");
        expectedException.expectMessage("test1参数必须在值{1,2,3}中！");
        ValidUtil.valid(testValidStrIn);
    }

    @Test
    public void test3() {
        TestValidStrIn testValidStrIn = new TestValidStrIn();
        testValidStrIn.setTest1("1");
        testValidStrIn.setTest2("2.2");
        ValidUtil.valid(testValidStrIn);
    }

    @Test
    public void test4() {
        TestValidStrIn testValidStrIn = new TestValidStrIn();
        testValidStrIn.setTest1("1");
        expectedException.expectMessage("test2参数必须在值{1.1,2.2,3.3}中！");
        ValidUtil.valid(testValidStrIn);
    }

    @Test
    public void test5() {
        TestValidStrIn testValidStrIn = new TestValidStrIn();
        testValidStrIn.setTest1("1");
        testValidStrIn.setTest2("1");
        expectedException.expectMessage("test2参数必须在值{1.1,2.2,3.3}中！");
        ValidUtil.valid(testValidStrIn);
    }

}
