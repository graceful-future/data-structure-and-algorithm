package com.gracefulfuture.data.structure.queue;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
* @description      ConcurrentBlockingQueue测试类
* @author           chenkun
* @create           2021/5/27 16:41
* @version          1.0
*/
public class ConcurrentBlockingQueueTest {
    public static void main(String[] args) {
        //基于链表节点的并发阻塞队列，不允许null元素
        //不定界(容量可以改变)
        Queue<String> concurrent =  new ConcurrentLinkedQueue<>();
//        concurrent.add(null);
        concurrent.add("purple");
        concurrent.add("blue");
        concurrent.add("indigo");
        concurrent.add("green");
        concurrent.add("yellow");
        concurrent.add("orange");
        concurrent.add("red");
        System.out.println(concurrent.size());
        System.out.println(concurrent.peek());
        System.out.println(concurrent.offer("undefined"));
        Iterator<String> iterator = concurrent.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
