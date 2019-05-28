package com.jg.tool.valid.min;

import com.jg.tool.TestImpl;
import com.jg.tool.valid.util.ValidUtil;
import org.junit.Test;

public class TestValidMin extends TestImpl {

    @Test
    public void test1() {
        TestMin testMin = new TestMin();
        ValidUtil.valid(testMin);
    }

}
