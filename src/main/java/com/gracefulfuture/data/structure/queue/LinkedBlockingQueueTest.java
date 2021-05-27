package com.gracefulfuture.data.structure.queue;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
* @description      LinkedBlockingQueue测试类
* @author           chenkun
* @create           2021/5/27 17:59
* @version          1.0
*/
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        //基于链表，可选有界，先进先出
        //吞入量高于基于数组的队列，不允许插入null元素
        Queue<String> linked = new LinkedBlockingQueue<>();
//        linked.add(null);
        linked.add("paddy");
        linked.add("wheat");
        linked.add("potato");
        linked.add("soybean");
        System.out.println(linked.peek());
        System.out.println(linked.offer("maize"));
        System.out.println(linked.poll());
        System.out.println(linked.size());
        Iterator<String> iterator = linked.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
