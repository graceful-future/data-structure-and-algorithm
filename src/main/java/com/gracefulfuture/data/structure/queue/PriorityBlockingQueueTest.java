package com.gracefulfuture.data.structure.queue;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
* @description      PriorityBlockingQueue测试类
* @author           chenkun
* @create           2021/5/28 8:55
* @version          1.0
*/
public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //基于平衡二叉堆(数组)，无界，不允许null元素，自然排序或指定排序规则排序
        //不保证插入元素顺序和遍历顺序一致
        PriorityBlockingQueue<Integer> priorityBlocking = new PriorityBlockingQueue<>();
//        priorityBlocking.add(null);
        priorityBlocking.addAll(Arrays.asList(5,3,2,4,1,7,6,9,10,8));
        System.out.println(priorityBlocking.peek());
//        System.out.println(priorityBlocking.poll());
        System.out.println(priorityBlocking.offer(1));
        priorityBlocking.drainTo(list);
        System.out.println(priorityBlocking.size());
        System.out.println("###########################");
        Iterator<Integer> iterator = priorityBlocking.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            System.out.print(next + "\t");
        }
        System.out.println();
        System.out.println("===========================");
        for (int i = 0; i < 11; i++) {
            System.out.print(priorityBlocking.poll() + "\t");
        }
    }
}
