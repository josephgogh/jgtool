package com.jg.tool.valid.size;

import com.jg.tool.TestImpl;
import org.junit.Test;

public class TestValidSize extends TestImpl {

    @Test
    public void test() {
        TestSize testSize = new TestSize();
        testSize.valid();
    }

    @Test
    public void test1() {
        TestSize1 testSize = new TestSize1();
        testSize.setTest("");
        testSize.valid();
    }

}
