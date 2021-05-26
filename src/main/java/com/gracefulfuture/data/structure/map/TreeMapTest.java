package com.gracefulfuture.data.structure.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
* @description      TreeMap测试类
* @author           chenkun
* @create           2021/5/26 17:18
* @version          1.0
*/
public class TreeMapTest {
    public static void main(String[] args) {
        //底层使用红黑树作为存储结构
        //不允许null键，允许null值
        //元素按照自然顺序排序且不可重复
        Map<String,Object> treeMap = new TreeMap<>();
//        treeMap.put(null,"xxx");
        treeMap.put("empty",null);
        treeMap.put("location","Exhibition Center");
        treeMap.put("position","Financial City");
        treeMap.put("country","China");
        treeMap.put("position","Talents City");
        treeMap.put("fullName","The People's Republic of China");
        Iterator<String> iterator = treeMap.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            String value = (String) treeMap.get(key);
            System.out.println(key + "-->" + value);
        }
    }
}
