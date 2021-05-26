package com.gracefulfuture.data.structure.set;

import java.util.TreeSet;

/**
* @description      TreeSet测试类
* @author           chenkun
* @create           2021/5/25 11:55
* @version          1.0
*/
public class TreeSetTest {
    public static void main(String[] args) {
        //TreeSet底层使用TreeMap作为数据结构，而TreeMap使用二叉树作为数据结构。
        //保存的元素在其内部按自然顺序排序,且元素不能为null。
        //元素不可重复
        TreeSet<Integer> treeSet = new TreeSet<>();
//        treeSet.add(10);
//        treeSet.add(8);
//        treeSet.add(15);
//        treeSet.add(12);
//        treeSet.add(12);
//        treeSet.add(6);
        Integer itg3 = new Integer(30);
        Integer itg5 = new Integer(30);
        Integer itg6 = 150;
        Integer itg7 = 150;
        Integer itg8 = Integer.valueOf(130);
        Integer itg9 = Integer.valueOf(130);
        treeSet.add(new Integer(20));
        treeSet.add(new Integer(15));
        treeSet.add(itg3);
        treeSet.add(new Integer(10));
        treeSet.add(itg5);
        System.out.println(itg3 == itg5);
//        System.out.println(itg6 == itg7);
//        System.out.println(itg8 == itg9);
//        System.out.println(itg3.intValue() == itg5.intValue());
//        System.out.println(treeSet.size());
//        System.out.println(treeSet);
        treeSet.forEach(integer -> System.out.println(integer));
//        TreeSet<String> treeSet2 = new TreeSet<>();
//        treeSet2.add("hello");
//        treeSet2.add("hello");
//        treeSet2.add("world");
//        treeSet2.add("welcome");
//        treeSet2.add("age");
//        treeSet2.add("boy");
//        treeSet2.add(null);
//        treeSet2.forEach(e -> System.out.println(e));
    }
}
