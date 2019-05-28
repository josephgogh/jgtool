package com.jg.tool.valid.morethan;

import com.jg.tool.TestImpl;
import com.jg.tool.valid.lessthan.TestValidLessThan;
import com.jg.tool.valid.util.ValidUtil;
import org.junit.Test;

public class TestValidIsMoreThan extends TestImpl {

    @Test
    public void test() {
        TestValidMoreThan testValidMoreThan = new TestValidMoreThan();
        ValidUtil.valid(testValidMoreThan);
    }


}
