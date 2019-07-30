package com.jg.tool.othervalid;

import com.jg.tool.TestImpl;
import com.jg.tool.valid.util.ValidUtil;
import org.junit.Assert;
import org.junit.Test;

public class TestTrueValid extends TestImpl {

    @Test
    public void isTrueWhenFalse() {
        expectedException.expectMessage("异常嘻嘻");
        ValidUtil.isTrue(false, "异常嘻嘻");
    }

    @Test
    public void isTrueWhenTrue() {
        ValidUtil.isTrue(true, "异常嘻嘻");
    }

    @Test
    public void isFalseWhenTrue() {
        ValidUtil.isFalse(false, "异常嘻嘻");
    }

    @Test
    public void isFalseWhenFalse() {
        expectedException.expectMessage("异常嘻嘻");
        ValidUtil.isFalse(true, "异常嘻嘻");
    }


}
