package com.jg.tool.valid.max;

import com.jg.tool.TestImpl;
import com.jg.tool.valid.util.ValidUtil;
import org.junit.Test;

public class TestValidMax extends TestImpl {

    @Test
    public void test1() {
        TestMax testMax = new TestMax();
        ValidUtil.valid(testMax);
    }

}
