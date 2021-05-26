package com.gracefulfuture.data.structure.map;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

/**
* @description      IdentityHashMap测试类
* @author           chenkun
* @create           2021/5/25 16:42
* @version          1.0
*/
public class IdentityHashMapTest {
    public static void main(String[] args) {
        //使用引用相等代替对象相等比较key,允许null键和值
        //元素无序且不可重复
        IdentityHashMap<String,Object> identity = new IdentityHashMap();
        String str1 = "name";
        String str2 = "name";
        String str3 = new String("name");
        String str4 = new String("name");
        identity.put(str3,"Zhangsan");
        identity.put(str4,"Lisi");
        identity.put("age",20);
        identity.put(null,"");
        identity.put(null,"");
        identity.put("empty",null);
//        System.out.println(str1 == str2);
//        System.out.println(str3 == str4);
        Object name = identity.get(str3);
        System.out.println(name);
        System.out.println(identity.size());
//        Iterator<Map.Entry<String, Object>> iterator = identity.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, Object> next = iterator.next();
//            System.out.println(next.getKey() + "-->" + next.getValue());
//        }
        for(Map.Entry entry : identity.entrySet()){
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}
