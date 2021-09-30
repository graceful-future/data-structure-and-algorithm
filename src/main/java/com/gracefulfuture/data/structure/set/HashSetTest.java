package com.gracefulfuture.data.structure.set;

import com.gracefulfuture.algorithm.distinct.Student;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
* @description      HashSet测试类
* @author           chenkun
* @create           2021/5/25 11:51
* @version          1.0
*/
public class HashSetTest {
    public static void main(String[] args) {
        //HashSet底层使用HashMap作为数据结构，由于HashMap不能
        //保证存储的元素有序性，所以HashSet中元素是无序的。
        //可以保存值为null的元素,元素不可重复
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(null);
//        boolean flag1 = hashSet.add("hello");
//        boolean flag2 = hashSet.add("hello");
//        System.out.println(flag1);
//        System.out.println(flag2);
//        hashSet.add("world");
//        hashSet.add("welcome");
//        hashSet.add("age");
//        System.out.println(hashSet.size());
//        System.out.println(hashSet);
        hashSet.forEach(System.out::println);
        HashSet<Integer> hashSet2  = new HashSet<>();
        hashSet2.add(100);
        hashSet2.add(1);
        hashSet2.add(2);
        hashSet2.add(4);
        hashSet2.add(3);
        hashSet2.add(100);
//        hashSet2.add(null);
//        hashSet2.add(null);
        hashSet2.forEach(System.out::println);
        HashSet<Student> hashSet3 = new HashSet<>();
        Student student1 = new Student("Lili",20);
        Student student2 = new Student("lili",20);
//        Student student2 = student1;
        hashSet3.add(student1);
        hashSet3.add(student2);
        System.out.println(hashSet3);
    }
}
