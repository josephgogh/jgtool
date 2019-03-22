package com.jg.tool.valid;

import com.jg.tool.TestImpl;
import com.jg.tool.valid.model.TestValidNumIn;
import com.jg.tool.valid.util.ValidUtil;
import org.junit.Test;

public class TestNumIn extends TestImpl {

    @Test
    public void test1() {
        TestValidNumIn testValidNumIn = new TestValidNumIn();
        expectedException.expectMessage("test1参数必须在值{1,2,3}中！");
        ValidUtil.valid(testValidNumIn);
    }
    @Test
    public void test2() {
        TestValidNumIn testValidNumIn = new TestValidNumIn();
        testValidNumIn.setTest1(0);
        expectedException.expectMessage("test1参数必须在值{1,2,3}中！");
        ValidUtil.valid(testValidNumIn);
    }

    @Test
    public void test3() {
        TestValidNumIn testValidNumIn = new TestValidNumIn();
        testValidNumIn.setTest1(1);
        testValidNumIn.setTest2(2.2);
        ValidUtil.valid(testValidNumIn);
    }

    @Test
    public void test4() {
        TestValidNumIn testValidNumIn = new TestValidNumIn();
        testValidNumIn.setTest1(1);
        expectedException.expectMessage("test2参数必须在值{1.1,2.2,3.3}中！");
        ValidUtil.valid(testValidNumIn);
    }

    @Test
    public void test5() {
        TestValidNumIn testValidNumIn = new TestValidNumIn();
        testValidNumIn.setTest1(1);
        testValidNumIn.setTest2(1);
        expectedException.expectMessage("test2参数必须在值{1.1,2.2,3.3}中！");
        ValidUtil.valid(testValidNumIn);
    }

}
