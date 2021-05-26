package com.gracefulfuture.data.structure.map;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
* @description      HashTable测试类
* @author           chenkun
* @create           2021/5/26 16:08
* @version          1.0
*/
public class HashTableTest {
    public static void main(String[] args) {
        //使用哈希表作为存储结构，多线程安全，不允许null键和值
        //元素不可重复且无须
        Hashtable<String,Object> hashtable = new Hashtable<>();
        hashtable.put("first","Huawei");
        hashtable.put("second","Apple");
        hashtable.put("third","Xiaomi");
        hashtable.put("fourth","SanXing");
        hashtable.put("last","xxx");
        hashtable.put("empty","");
        hashtable.put("third","Xiaomi");
        System.out.println(hashtable.size());
        Iterator<Map.Entry<String, Object>> iterator = hashtable.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey() + "-->" + next.getValue());
        }
    }
}
