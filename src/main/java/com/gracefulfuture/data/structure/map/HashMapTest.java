package com.gracefulfuture.data.structure.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author chenkun
 * @version 1.0
 * @description HashMap测试类
 * @date 2021/9/23 11:02
 */
public class HashMapTest {
    public static void main(String[] args) {
        /**
         * 使用哈希表作为数据结构，允许null键和null值
         * 元素无序切不可重复
         */
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put(null,null);
        hashMap.put(null,20);
        hashMap.put("aaa","Beijing");
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            System.out.println(entry);
        }
    }
}
