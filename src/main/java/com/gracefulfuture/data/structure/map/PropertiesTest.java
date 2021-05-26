package com.gracefulfuture.data.structure.map;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
* @description      Properties测试类
* @author           chenkun
* @create           2021/5/26 16:26
* @version          1.0
*/
public class PropertiesTest {
    public static void main(String[] args) {
        //不允许null键和值，元素无序且不可重复
        //多线程安全
        Properties properties = new Properties();
        properties.put("first","China");
        properties.put("second","Russia");
        properties.put("third","America");
        properties.put("second","Russia");
//        properties.put(null,"xxx");
//        properties.put("xxx",null);
        properties.setProperty("xxx","unknown");
        properties.setProperty("fourth","France");
        properties.put("fifth",new Object());
        properties.put(new Integer(2),"Integer");
        System.out.println(properties.size());
//        System.out.println(properties.isEmpty());
//        System.out.println(properties.propertyNames());
        Iterator<Map.Entry<Object, Object>> iterator = properties.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Object, Object> next = iterator.next();
            System.out.println(next.getKey() + "-->" + next.getValue());
        }
    }
}
