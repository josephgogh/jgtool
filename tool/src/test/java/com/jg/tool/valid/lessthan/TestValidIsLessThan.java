package com.jg.tool.valid.lessthan;

import com.jg.tool.TestImpl;
import com.jg.tool.valid.isphonenum.TestIsPhoneNum;
import com.jg.tool.valid.isphonenum.TestIsPhoneNum2;
import com.jg.tool.valid.util.ValidUtil;
import org.junit.Test;

public class TestValidIsLessThan extends TestImpl {

    @Test
    public void test() {
        TestValidLessThan testValidLessThan = new TestValidLessThan();
        ValidUtil.valid(testValidLessThan);
    }


}
