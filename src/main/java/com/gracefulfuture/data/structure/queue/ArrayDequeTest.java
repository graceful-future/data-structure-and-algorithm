package com.gracefulfuture.data.structure.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
* @description      ArrayDeque测试类
* @author           chenkun
* @create           2021/6/15 16:44
* @version          1.0
*/
public class ArrayDequeTest {
    public static void main(String[] args) {
        //可变容量，非空元素，线程不安全
        Deque<String> arrayDeque = new ArrayDeque<>();
//        arrayDeque.offer(null);
        arrayDeque.push("sky");
        arrayDeque.add("sea");
        arrayDeque.add("grassland");
        arrayDeque.push("plain");
        System.out.println(arrayDeque.getFirst());
        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque.getLast());
        System.out.println(arrayDeque.size());
        Iterator<String> iterator = arrayDeque.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
