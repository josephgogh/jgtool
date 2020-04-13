package com.jg.tool.util;

import com.jg.tool.TestImpl;
import org.junit.Assert;
import org.junit.Test;

public class TestStrTool extends TestImpl {

    @Test
    public void TestFromHump1() {
        String str = null;
        String result = StrTool.fromHump(str);
        Assert.assertEquals(result, str);
        str = "test1";
        result = StrTool.fromHump(str);
        Assert.assertEquals(result, str);
        str = "testA1";
        result = StrTool.fromHump(str);
        Assert.assertEquals(result, "test_a1");
        str = "TestAc";
        result = StrTool.fromHump(str);
        Assert.assertEquals(result, "test_ac");
        str = "TestAB";
        result = StrTool.fromHump(str);
        Assert.assertEquals(result, "test_a_b");
    }

}
