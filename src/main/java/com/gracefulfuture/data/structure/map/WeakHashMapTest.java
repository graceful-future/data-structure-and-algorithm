package com.gracefulfuture.data.structure.map;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
* @description      WeakHashMap测试类
* @author           chenkun
* @create           2021/5/26 15:31
* @version          1.0
*/
public class WeakHashMapTest {
    public static void main(String[] args) {
        //使用哈希表作为存储结构，元素无序
        //允许null键和值，当键不被使用，元素被删除。
        WeakHashMap<String,Object> weakHashMap = new WeakHashMap<>();
        weakHashMap.put("null","apple");
        weakHashMap.put("second","pear");
        weakHashMap.put("third","orange");
        weakHashMap.put("second","pear");
        weakHashMap.put("fourth",null);
        weakHashMap.put("fifth","banana");
        weakHashMap.put("sixth","strawberry");
        weakHashMap.put("null","apple");
        System.out.println(weakHashMap.size());
        Iterator<Map.Entry<String, Object>> iterator = weakHashMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey() + "-->" + next.getValue());
        }

    }
}
