package com.jg.tool.valid.numin;

import com.jg.tool.TestImpl;
import com.jg.tool.valid.util.ValidUtil;
import org.junit.Test;

public class TestValidNumIn extends TestImpl {

    @Test
    public void test() {
        TestNumIn testNumIn = new TestNumIn();
        ValidUtil.valid(testNumIn);
    }

}
