package com.gracefulfuture.data.structure.queue;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

/**
* @description      DelayQueue测试类
* @author           chenkun
* @create           2021/5/27 17:09
* @version          1.0
*/
public class DelayQueueTest {
    public static void main(String[] args) {
        //不允许插入null元素,队首存放离过期时间最近的元素
        //不能迭代顺序和保存元素时的顺序一致
        Queue<Element> delay = new DelayQueue<>();
        Element element1 = new Element("e1",3);
        Element element2 = new Element("e2",5);
        Element element3 = new Element("e3",1);
        Element element5 = new Element("e5",1);
//        delay.add(null);
        delay.add(element1);
        delay.add(element2);
        delay.add(element3);
        delay.add(element5);
        System.out.println(delay.offer(new Element("e4",2)));
        System.out.println(delay.peek());
        System.out.println(delay.poll());
        System.out.println(delay.peek());
        System.out.println(delay.size());
        Iterator<Element> iterator = delay.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
