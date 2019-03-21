package com.jg.tool.valid;


import com.jg.tool.TestImpl;
import com.jg.tool.exception.ValidationException;
import com.jg.tool.valid.model.*;
import com.jg.tool.valid.util.ValidUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestValid extends TestImpl{

    @Test
    public void testNotNullWhenNotNull() {
        TestValidNotNull testValidNotNull = new TestValidNotNull();
        testValidNotNull.setTest1("");
        testValidNotNull.setTest2("");
        testValidNotNull.valid();
    }

    @Test
    public void testNotNullWhenNull() {
        TestValidNotNull testValidNotNull = new TestValidNotNull();
        testValidNotNull.setTest2("");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数不能为空！");
        testValidNotNull.valid();
    }

    @Test
    public void testNotNullWhenNullAndCustomMessage() {
        TestValidNotNull testValidNotNull = new TestValidNotNull();
        testValidNotNull.setTest1("");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("测试2不能为空！");
        testValidNotNull.valid();
    }

    @Test
    public void testNullWhenNull() {
        TestValidNull testValidNull = new TestValidNull();
        testValidNull.valid();
    }

    @Test
    public void testNullWhenNotNull() {
        TestValidNull testValidNull = new TestValidNull();
        testValidNull.setTest1("");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须为空！");
        testValidNull.valid();
    }

    @Test
    public void testNullWhenNotNUllAndCustomMessage() {
        TestValidNull testValidNull = new TestValidNull();
        testValidNull.setTest2("");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("测试2必须为空！");
        testValidNull.valid();
    }

    @Test
    public void testNumberWhenNull() {
        TestValidNumber testValidNumber = new TestValidNumber();
        testValidNumber.setTest1(null);
        ValidUtil.valid(testValidNumber);
    }

    @Test
    public void testNumberWhenTest1IsNum() {
        TestValidNumber testValidNumber = new TestValidNumber();
        testValidNumber.setTest1("123d");
        ValidUtil.valid(testValidNumber);
    }

    @Test
    public void testNumberWhenTest1IsNotNum() {
        TestValidNumber testValidNumber = new TestValidNumber();
        testValidNumber.setTest1("123df");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须为数字格式！");
        ValidUtil.valid(testValidNumber);
    }

    @Test
    public void testNumberWhenTest2IsNotNumAndCustomMessage() {
        TestValidNumber testValidNumber = new TestValidNumber();
        testValidNumber.setTest2("123df");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("测试2必须为数字类型！");
        ValidUtil.valid(testValidNumber);
    }

    @Test
    public void testMinWhenTest1IsNull() {
        TestValidMin testValidMin = new TestValidMin();
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须大等于10！");
        ValidUtil.valid(testValidMin);
    }

    @Test
    public void testMinWhenTest1IsNotNum() {
        TestValidMin testValidMin = new TestValidMin();
        testValidMin.setTest1("123df");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须大等于10！");
        ValidUtil.valid(testValidMin);
    }

    @Test
    public void testMinWhenTest1IsNum() {
        TestValidMin testValidMin = new TestValidMin();
        testValidMin.setTest2(22);
        testValidMin.setTest1("123");
        ValidUtil.valid(testValidMin);
        testValidMin.setTest1("1");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须大等于10！");
        ValidUtil.valid(testValidMin);
    }

    @Test
    public void testMinWhenTest2() {
        TestValidMin testValidMin = new TestValidMin();
        testValidMin.setTest2(22);
        testValidMin.setTest1("123");
        ValidUtil.valid(testValidMin);
        testValidMin.setTest2(1);
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("测试2必须大于20");
        ValidUtil.valid(testValidMin);
    }

    @Test
    public void testMoreThanWhenTest1IsNull() {
        TestValidMoreThan testValidMoreThan = new TestValidMoreThan();
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须大于10！");
        ValidUtil.valid(testValidMoreThan);
    }

    @Test
    public void testMoreThanWhenTest1IsNotNum() {
        TestValidMoreThan testValidMoreThan = new TestValidMoreThan();
        testValidMoreThan.setTest1("123df");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须大于10！");
        ValidUtil.valid(testValidMoreThan);
    }

    @Test
    public void testMoreThanWhenTest1IsNum() {
        TestValidMoreThan testValidMoreThan = new TestValidMoreThan();
        testValidMoreThan.setTest2(22);
        testValidMoreThan.setTest1("123");
        ValidUtil.valid(testValidMoreThan);
        testValidMoreThan.setTest1("1");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须大于10！");
        ValidUtil.valid(testValidMoreThan);
    }

    @Test
    public void testMoreThanWhenTest2() {
        TestValidMoreThan testValidMoreThan = new TestValidMoreThan();
        testValidMoreThan.setTest2(22);
        testValidMoreThan.setTest1("123");
        ValidUtil.valid(testValidMoreThan);
        testValidMoreThan.setTest2(1);
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("测试2必须大于20");
        ValidUtil.valid(testValidMoreThan);
    }

    @Test
    public void testMaxWhenTest1IsNull() {
        TestValidMax testValidMax = new TestValidMax();
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须小等于10！");
        ValidUtil.valid(testValidMax);
    }

    @Test
    public void testMaxWhenTest1IsNotNum() {
        TestValidMax testValidMax = new TestValidMax();
        testValidMax.setTest1("123df");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须小等于10！");
        ValidUtil.valid(testValidMax);
    }

    @Test
    public void testMaxWhenTest1IsNum() {
        TestValidMax testValidMax = new TestValidMax();
        testValidMax.setTest2(1);
        testValidMax.setTest1("10");
        ValidUtil.valid(testValidMax);
        testValidMax.setTest1("123");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须小等于10！");
        ValidUtil.valid(testValidMax);
    }

    @Test
    public void testMaxWhenTest2() {
        TestValidMax testValidMax = new TestValidMax();
        testValidMax.setTest2(1);
        testValidMax.setTest1("1");
        ValidUtil.valid(testValidMax);
        testValidMax.setTest2(123);
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("测试2必须小于20");
        ValidUtil.valid(testValidMax);
    }

    @Test
    public void testLessThanWhenTest1IsNull() {
        TestValidLessThan testValidLessThan = new TestValidLessThan();
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须小于10！");
        ValidUtil.valid(testValidLessThan);
    }

    @Test
    public void testLessThanWhenTest1IsNotNum() {
        TestValidLessThan testValidLessThan = new TestValidLessThan();
        testValidLessThan.setTest1("123df");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须小于10！");
        ValidUtil.valid(testValidLessThan);
    }

    @Test
    public void testLessThanWhenTest1IsNum() {
        TestValidLessThan testValidLessThan = new TestValidLessThan();
        testValidLessThan.setTest2(1);
        testValidLessThan.setTest1("9");
        ValidUtil.valid(testValidLessThan);
        testValidLessThan.setTest1("123");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须小于10！");
        ValidUtil.valid(testValidLessThan);
    }

    @Test
    public void testLessThanWhenTest2() {
        TestValidLessThan testValidLessThan = new TestValidLessThan();
        testValidLessThan.setTest2(1);
        testValidLessThan.setTest1("1");
        ValidUtil.valid(testValidLessThan);
        testValidLessThan.setTest2(123);
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("测试2必须小于20");
        ValidUtil.valid(testValidLessThan);
    }

    @Test
    public void testSizeWhenTest1IsNullAndTest2IsNull() {
        TestValidSize testValidSize = new TestValidSize();
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("测试参数2长度必须在1-10之间");
        testValidSize.valid();

    }

    @Test
    public void testSizeWhenTest1IsNotNullAndLengthMoreThan10() {
        TestValidSize testValidSize = new TestValidSize();
        testValidSize.setTest1("sdfsfsdfsdfsdfd");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数长度必须在0-10之间！");
        testValidSize.valid();
        testValidSize.setTest1("123");
        testValidSize.setTest2("123");
        testValidSize.valid();
    }

    @Test
    public void testPatternWhenTest1() {
        TestValidPattern testValidPattern = new TestValidPattern();
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数不符合正则表达式规则{^(.+)@(.+)$}！");
        testValidPattern.valid();
        testValidPattern.setTest1("12312@qq.com");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("邮箱的格式不合法");
        testValidPattern.valid();
        testValidPattern.setTest2("12312@qq.com");
        testValidPattern.valid();
    }

    @Test
    public void testPatternWhenTest2() {
        TestValidPattern testValidPattern = new TestValidPattern();
        testValidPattern.setTest1("12312@qq.com");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("邮箱的格式不合法");
        testValidPattern.valid();
        testValidPattern.setTest2("12312@qq.com");
        testValidPattern.valid();
    }

    @Test
    public void testEmptyWhenTest1() {
        TestValidEmpty testValidEmpty = new TestValidEmpty();
        testValidEmpty.valid();
        testValidEmpty.setTest1("");
        testValidEmpty.valid();
        testValidEmpty.setTest1(" ");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数必须为空！");
        testValidEmpty.valid();
    }

    @Test
    public void testEmptyWhenTest2() {
        TestValidEmpty testValidEmpty = new TestValidEmpty();
        testValidEmpty.setTest2(new String[] {});
        testValidEmpty.valid();
        testValidEmpty.setTest2(new String[] {""});
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("数组必须为空");
        testValidEmpty.valid();
    }

    @Test
    public void testEmptyWhenTest3() {
        TestValidEmpty testValidEmpty = new TestValidEmpty();
        List<String> list = new ArrayList<>();
        testValidEmpty.setTest3(list);
        testValidEmpty.valid();
        list.add("asasd");
        testValidEmpty.setTest3(list);
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test3参数必须为空！");
        testValidEmpty.valid();
    }

    @Test
    public void testEmptyWhenTest4() {
        TestValidEmpty testValidEmpty = new TestValidEmpty();
        Map<String, String> map = new HashMap<>();
        testValidEmpty.setTest4(map);
        testValidEmpty.valid();
        map.put("123", "123");
        testValidEmpty.setTest4(map);
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test4参数必须为空！");
        testValidEmpty.valid();
    }

    @Test
    public void testNotEmptyWhenTest1() {
        TestValidNotEmpty testValidNotEmpty = new TestValidNotEmpty();
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数不能为空！");
        testValidNotEmpty.valid();
    }

    @Test
    public void testNotEmptyWhenTest1IsEmpty() {
        TestValidNotEmpty testValidNotEmpty = new TestValidNotEmpty();
        testValidNotEmpty.setTest1("");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test1参数不能为空！");
        testValidNotEmpty.valid();
    }

    @Test
    public void testNotEmptyWhenTest2() {
        TestValidNotEmpty testValidNotEmpty = new TestValidNotEmpty();
        testValidNotEmpty.setTest1(" ");
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("数组必须不为空");
        testValidNotEmpty.valid();
    }

    @Test
    public void testNotEmptyWhenTest2IsEmpty() {
        TestValidNotEmpty testValidNotEmpty = new TestValidNotEmpty();
        testValidNotEmpty.setTest1(" ");
        testValidNotEmpty.setTest2(new String[] {});
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("数组必须不为空");
        testValidNotEmpty.valid();
    }

    @Test
    public void testNotEmptyWhenTest3() {
        TestValidNotEmpty testValidNotEmpty = new TestValidNotEmpty();
        testValidNotEmpty.setTest1(" ");
        testValidNotEmpty.setTest2(new String[] {""});
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test3参数不能为空！");
        testValidNotEmpty.valid();
    }

    @Test
    public void testNotEmptyWhenTest3IsEmpty() {
        TestValidNotEmpty testValidNotEmpty = new TestValidNotEmpty();
        testValidNotEmpty.setTest1(" ");
        testValidNotEmpty.setTest2(new String[] {""});
        List<String> list = new ArrayList<>();
        testValidNotEmpty.setTest3(list);
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test3参数不能为空！");
        testValidNotEmpty.valid();
    }

    @Test
    public void testNotEmptyWhenTest4() {
        TestValidNotEmpty testValidNotEmpty = new TestValidNotEmpty();
        testValidNotEmpty.setTest1(" ");
        testValidNotEmpty.setTest2(new String[] {""});
        List<String> list = new ArrayList<>();
        list.add("sdf");
        testValidNotEmpty.setTest3(list);
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test4参数不能为空！");
        testValidNotEmpty.valid();
    }

    @Test
    public void testNotEmptyWhenTest4IsEmpty() {
        TestValidNotEmpty testValidNotEmpty = new TestValidNotEmpty();
        testValidNotEmpty.setTest1(" ");
        testValidNotEmpty.setTest2(new String[] {""});
        List<String> list = new ArrayList<>();
        list.add("sdf");
        testValidNotEmpty.setTest3(list);
        Map<String, String> map = new HashMap<>();
        testValidNotEmpty.setTest4(map);
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("test4参数不能为空！");
        testValidNotEmpty.valid();
    }

    @Test
    public void testNotEmptyWhenTest4IsNotEmpty() {
        TestValidNotEmpty testValidNotEmpty = new TestValidNotEmpty();
        testValidNotEmpty.setTest1(" ");
        testValidNotEmpty.setTest2(new String[] {""});
        List<String> list = new ArrayList<>();
        list.add("sdf");
        testValidNotEmpty.setTest3(list);
        Map<String, String> map = new HashMap<>();
        map.put("123", "123");
        testValidNotEmpty.setTest4(map);
        testValidNotEmpty.valid();
    }

    @Test
    public void testFl() {
        TestFl testFl = new TestFl();
        expectedException.expectMessage("test不能为空！");
        testFl.valid();
    }

    @Test
    public void testZl() {
        TestZl testZl = new TestZl();
        testZl.setTest1("12312312");
        expectedException.expectMessage("test不能为空！");
        testZl.valid();
    }

    @Test
    public void testZl12() {
        TestZl2 testZl2 = new TestZl2();
        testZl2.setTest("12312312");
        testZl2.setTest2("1231231232");
        expectedException.expectMessage("test1不能为空！");
        testZl2.valid();
    }

    @Test
    public void testZl2() {
        TestZl2 testZl2 = new TestZl2();
        expectedException.expectMessage("test2不能为空！");
        testZl2.valid();
    }
}
