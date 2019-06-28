package com.jg.tool.othervalid;

import com.jg.tool.TestImpl;
import com.jg.tool.valid.util.ValidUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TestBlankValid extends TestImpl {

    @Test
    public void StrIsBlank() {
        String str = null;
        boolean result = ValidUtil.isBlank(str);
        Assert.assertTrue(result);
    }

    @Test
    public void StrIsBlank1() {
        String str = "";
        boolean result = ValidUtil.isBlank(str);
        Assert.assertTrue(result);
    }

    @Test
    public void StrIsBlank2() {
        String str = "123";
        boolean result = ValidUtil.isBlank(str);
        Assert.assertFalse(result);
    }

    @Test
    public void StrIsNotBlank() {
        String str = null;
        boolean result = ValidUtil.isNotBlank(str);
        Assert.assertFalse(result);
    }

    @Test
    public void StrIsNotBlank1() {
        String str = "";
        boolean result = ValidUtil.isNotBlank(str);
        Assert.assertFalse(result);
    }

    @Test
    public void StrIsNotBlank2() {
        String str = "123";
        boolean result = ValidUtil.isNotBlank(str);
        Assert.assertTrue(result);
    }

    @Test
    public void mapIsBlank() {
        Map<String, String> map = null;
        boolean result = ValidUtil.isBlank(map);
        Assert.assertTrue(result);
    }

    @Test
    public void mapIsBlank1() {
        Map<String, String> map = new HashMap<>();
        boolean result = ValidUtil.isBlank(map);
        Assert.assertTrue(result);
    }

    @Test
    public void mapIsBlank2() {
        Map<String, String> map = new HashMap<>();
        map.put("123", "123");
        boolean result = ValidUtil.isBlank(map);
        Assert.assertFalse(result);
    }

    @Test
    public void mapIsNotBlank() {
        Map<String, String> map = null;
        boolean result = ValidUtil.isNotBlank(map);
        Assert.assertFalse(result);
    }

    @Test
    public void mapIsNotBlank1() {
        Map<String, String> map = new HashMap<>();
        boolean result = ValidUtil.isNotBlank(map);
        Assert.assertFalse(result);
    }

    @Test
    public void mapIsNotBlank2() {
        Map<String, String> map = new HashMap<>();
        map.put("123", "123");
        boolean result = ValidUtil.isNotBlank(map);
        Assert.assertTrue(result);
    }

    @Test
    public void CollectionIsBlank() {
        List<String> list = null;
        boolean result = ValidUtil.isBlank(list);
        Assert.assertTrue(result);
    }

    @Test
    public void CollectionIsBlank1() {
        List<String> list = new ArrayList<>();
        boolean result = ValidUtil.isBlank(list);
        Assert.assertTrue(result);
    }

    @Test
    public void CollectionIsBlank2() {
        List<String> list = new ArrayList<>();
        list.add("12312");
        boolean result = ValidUtil.isBlank(list);
        Assert.assertFalse(result);
    }

    @Test
    public void CollectionIsNotBlank() {
        Set<String> set = null;
        boolean result = ValidUtil.isNotBlank(set);
        Assert.assertFalse(result);
    }

    @Test
    public void CollectionIsNotBlank1() {
        Set<String> set = new HashSet<>();
        boolean result = ValidUtil.isNotBlank(set);
        Assert.assertFalse(result);
    }

    @Test
    public void CollectionIsNotBlank2() {
        Set<String> set = new HashSet<>();
        set.add("123");
        boolean result = ValidUtil.isNotBlank(set);
        Assert.assertTrue(result);
    }

    @Test
    public void ObjectsIsBlank() {
        String[] strs = null;
        boolean result = ValidUtil.isBlank(strs);
        Assert.assertTrue(result);
    }

    @Test
    public void ObjectsIsBlank1() {
        String[] strs = new String[]{};
        boolean result = ValidUtil.isBlank(strs);
        Assert.assertTrue(result);
    }

    @Test
    public void ObjectsIsBlank2() {
        String[] strs = new String[]{"123", "12323"};
        boolean result = ValidUtil.isBlank(strs);
        Assert.assertFalse(result);
    }

    @Test
    public void ObjectsIsBlank4() {
        Integer[] ints = null;
        boolean result = ValidUtil.isBlank(ints);
        Assert.assertTrue(result);
    }

    @Test
    public void ObjectsIsBlank5() {
        Integer[] ints = new Integer[]{};
        boolean result = ValidUtil.isBlank(ints);
        Assert.assertTrue(result);
    }

    @Test
    public void ObjectsIsBlank6() {
        Integer[] ints = new Integer[]{1, 2, 3};
        boolean result = ValidUtil.isBlank(ints);
        Assert.assertFalse(result);
    }

    @Test
    public void ObjectsIsNotBlank7() {
        Integer[] ints = null;
        boolean result = ValidUtil.isNotBlank(ints);
        Assert.assertFalse(result);
    }

    @Test
    public void ObjectsIsNotBlank8() {
        int[] ints = new int[]{};
        boolean result = ValidUtil.isNotBlank(ints);
        Assert.assertFalse(result);
    }

    @Test
    public void ObjectsIsNotBlank9() {
        Integer[] ints = new Integer[]{1, 2, 3};
        boolean result = ValidUtil.isNotBlank(ints);
        Assert.assertTrue(result);
    }

}
