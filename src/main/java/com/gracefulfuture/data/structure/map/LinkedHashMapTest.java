package com.gracefulfuture.data.structure.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
* @description      LinkedHashMap测试类
* @author           chenkun
* @create           2021/5/25 20:40
* @version          1.0
*/
public class LinkedHashMapTest {
    public static void main(String[] args) {
        //元素保持着插入式的顺序
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("city","Beijing");
        map.put("road","Chao yang road");
        map.put("street","朝阳门外大街");
        map.put("city","Beijing");
        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}
