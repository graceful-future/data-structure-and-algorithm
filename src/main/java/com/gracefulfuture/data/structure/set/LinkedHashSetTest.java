package com.gracefulfuture.data.structure.set;

import java.util.LinkedHashSet;

/**
* @description      LinkedHashSet测试类
* @author           chenkun
* @create           2021/6/21 17:00
* @version          1.0
*/
public class LinkedHashSetTest {
    public static void main(String[] args) {
        //基于哈希表和链表，允许非空元素，线程不安全
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(null);
        boolean flag1 = linkedHashSet.add(2);
        boolean flag2 = linkedHashSet.add(2);
        linkedHashSet.add(5);
        linkedHashSet.add(6);
        linkedHashSet.add(4);
        linkedHashSet.add(8);
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(linkedHashSet);
    }
}
