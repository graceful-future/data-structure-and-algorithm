package com.gracefulfuture.data.structure.queue;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
* @description      LinkedBlockingDeque测试类
* @author           chenkun
* @create           2021/5/28 14:29
* @version          1.0
*/
public class LinkedBlockingDequeTest {
    public static void main(String[] args) throws InterruptedException {
        //基于链表，可选定界，阻塞双端队列
        //元素不可为null
        LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>();
        linkedBlockingDeque.add(20);
//        linkedBlockingDeque.add(null);
        linkedBlockingDeque.addFirst(50);
        linkedBlockingDeque.addLast(30);
        linkedBlockingDeque.offerFirst(60);
        linkedBlockingDeque.offerLast(40);
        linkedBlockingDeque.add(10);
        linkedBlockingDeque.put(70);
        linkedBlockingDeque.putFirst(80);
        linkedBlockingDeque.putLast(90);
        linkedBlockingDeque.offer(100);
        System.out.println(linkedBlockingDeque.peek());
        System.out.println(linkedBlockingDeque.peekFirst());
        System.out.println(linkedBlockingDeque.peekLast());
//        System.out.println(linkedBlockingDeque.poll());
        System.out.println(linkedBlockingDeque.getFirst());
        System.out.println(linkedBlockingDeque.getLast());
        System.out.println(linkedBlockingDeque.offerFirst(0, 2,TimeUnit.SECONDS));
        System.out.println(linkedBlockingDeque.size());
    }
}
