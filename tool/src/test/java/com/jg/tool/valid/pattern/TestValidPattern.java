package com.jg.tool.valid.pattern;

import com.jg.tool.TestImpl;
import org.junit.Test;

public class TestValidPattern extends TestImpl {

    @Test
    public void test() {
        TestPattern testPattern = new TestPattern();
        testPattern.valid();
    }

    @Test
    public void test1() {
        TestPattern1 testPattern = new TestPattern1();
        testPattern.valid();
    }

}
