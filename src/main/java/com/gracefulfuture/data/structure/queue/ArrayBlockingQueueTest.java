package com.gracefulfuture.data.structure.queue;

import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
* @description      ArrayBlockingQueue测试类
* @author           chenkun
* @create           2021/5/27 14:47
* @version          1.0
*/
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        //采用数组作为数据结构,先进先出，支持多线程
        Queue<String> blocking = new ArrayBlockingQueue(5);
        blocking.add("Asia");
        blocking.add("Europe");
        blocking.add("Africa");
        blocking.add("Oceania");
        blocking.add("North America");
//        blocking.add("Antarctica");
        System.out.println(blocking.offer(" South America"));
        System.out.println(blocking.peek());
        System.out.println(blocking.element());
        System.out.println(blocking.poll());
        System.out.println(blocking.remove());
        System.out.println(blocking.size());
        for (String s : blocking) {
            System.out.println(s);
        }
    }
}
