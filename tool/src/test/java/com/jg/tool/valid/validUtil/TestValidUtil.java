package com.jg.tool.valid.validUtil;

import com.jg.tool.TestImpl;
import com.jg.tool.valid.util.ValidUtil;
import org.junit.Test;

public class TestValidUtil extends TestImpl {

    @Test
    public void testNotNull() {
        expectedException.expectMessage("参数不能为空！");
        ValidUtil.notNull(null, "参数不能为空！");
    }

    @Test
    public void testisNull() {
        expectedException.expectMessage("参数必须为空！");
        ValidUtil.isNull("", "参数必须为空！");
    }

    @Test
    public void testNotEmpty() {
        String test = null;
        expectedException.expectMessage("字符串不能为空！");
        ValidUtil.notEmpty(test, "字符串不能为空！");
    }

    @Test
    public void testNotEmpty2() {
        String test = "";
        expectedException.expectMessage("字符串不能为空！");
        ValidUtil.notEmpty(test, "字符串不能为空！");
    }

    @Test
    public void testIsEmpty() {
        String test = "123";
        expectedException.expectMessage("字符串必须为空！");
        ValidUtil.isEmpty(test, "字符串必须为空！");
    }

}
