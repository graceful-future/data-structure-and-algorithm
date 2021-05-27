package com.gracefulfuture.data.structure.queue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
* @description      PriorityQueue测试类
* @author           chenkun
* @create           2021/5/27 18:22
* @version          1.0
*/
public class PriorityQueueTest {
    public static void main(String[] args) {
        //基于优先级堆(数组)，元素按自然顺序排序或指定排序规则排序
        //不允许保存null元素，不能保证遍历顺序和插入顺序一致
        Queue<String> priority = new PriorityQueue<>();
//        priority.add(null);
        priority.add("city");
        priority.add("building");
        priority.add("floor");
        priority.add("room");
        priority.add("house");
        priority.add("home");
        priority.add("family");
        priority.add("home");
        priority.add("area");
        System.out.println(priority.peek());
//        System.out.println(priority.poll());
        System.out.println(priority.offer("member"));
        System.out.println(priority.size());
        System.out.println("----------------");
        Iterator<String> iterator = priority.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=================");
        for (String s : priority) {
            System.out.println(s);
        }
    }
}
