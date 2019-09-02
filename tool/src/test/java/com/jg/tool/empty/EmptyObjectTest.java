package com.jg.tool.empty;

import com.jg.tool.TestImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class EmptyObjectTest extends TestImpl {

    @Test
    public void test1() {
        List<String> list = null;
        Assert.assertNotNull(EmptyObject.list(list));
    }

    @Test
    public void test2() {
        List<String> list = null;
        int i = 0;
        for (String str : EmptyObject.list(list)) {
            i++;
        }
        Assert.assertEquals(i, 0, 0);
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("1");
        int i = 0;
        for (String str : EmptyObject.list(list)) {
            i++;
        }
        Assert.assertEquals(i, 1, 0);
    }

    @Test
    public void testSet1() {
        Set<String> set = null;
        Assert.assertNotNull(EmptyObject.set(set));
    }

    @Test
    public void testSet2() {
        Set<String> set = null;
        int i = 0;
        for (String str : EmptyObject.set(set)) {
            i++;
        }
        Assert.assertEquals(i, 0, 0);
    }

    @Test
    public void testSet3() {
        Set<String> set = new HashSet<>();
        set.add("1");
        int i = 0;
        for (String str : EmptyObject.set(set)) {
            i++;
        }
        Assert.assertEquals(i, 1, 0);
    }

    @Test
    public void testMap1() {
        Map<String, String> map = null;
        Assert.assertNotNull(EmptyObject.map(map));
    }

    @Test
    public void testMap2() {
        Map<String, String> map = null;
        int i = 0;
        for (String key : EmptyObject.map(map).keySet()) {
            i++;
        }
        Assert.assertEquals(i, 0, 0);
    }

    @Test
    public void testMap3() {
        Map<String, String> map = new HashMap<>();
        map.put("test", "name");
        int i = 0;
        for (String key : EmptyObject.map(map).keySet()) {
            i++;
        }
        Assert.assertEquals(i, 1, 0);
    }

    @Test
    public void testMap4() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        int i = 0;
        for (int key : EmptyObject.map(map).keySet()) {
            i++;
        }
        Assert.assertEquals(i, 1, 0);
    }


    @Test
    public void testObject1() {
        String[] array = new String[]{"1"};
        int i = 0;
        for (String key : EmptyObject.object(array, new String[0])) {
            i++;
        }
        Assert.assertEquals(i, 1, 0);
    }

    @Test
    public void testObject2() {
        String[] array = null;
        int i = 0;
        for (String key : EmptyObject.object(array, new String[0])) {
            i++;
        }
        Assert.assertEquals(i, 0, 0);
    }

    @Test
    public void testObject3() {
        String[] array = null;
        int i = 0;
        expectedException.expectMessage("默认对象不能为null！");
        for (String key : EmptyObject.object(array, null)) {
            i++;
        }
        Assert.assertEquals(i, 0, 0);
    }
}
