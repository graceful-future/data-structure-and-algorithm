package com.gracefulfuture.data.structure.map;

import java.util.EnumMap;
import java.util.Map;

/**
* @description      EnumMap测试类
* @author           chenkun
* @create           2021/5/25 21:21
* @version          1.0
*/
public class EnumMapTest {
    public static void main(String[] args) {
        //使用数组作为存储结构，内部元素有序且不可重复
        EnumMap<DegreeEnum,Object> enumMap = new EnumMap<>(DegreeEnum.class);
        enumMap.put(DegreeEnum.BACHELOR,"bachelor");
        enumMap.put(DegreeEnum.DOCTOR,"doctor");
        enumMap.put(DegreeEnum.MASTER,"master");
        enumMap.put(DegreeEnum.DOCTOR,"doctor");
        System.out.println(enumMap.size());
        for(Map.Entry entry : enumMap.entrySet()){
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}
