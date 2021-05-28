package com.gracefulfuture.data.structure.queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
* @description      TransferQueue测试类
* @author           chenkun
* @create           2021/5/28 10:59
* @version          1.0
*/
public class LinkedTransferQueueTest {
    public static void main(String[] args) {
        //无界，基于链表，不允许null元素,先进先出，支持异步
        TransferQueue<Integer> transfer = new LinkedTransferQueue<>();
//        transfer.add(null);
        transfer.add(1);
        transfer.add(3);
        transfer.add(4);
        transfer.add(2);
        transfer.add(5);
        transfer.add(7);
        transfer.add(6);
        System.out.println(transfer.peek());
        System.out.println(transfer.size());
        System.out.println("-----------------");
        for (Integer integer : transfer) {
            System.out.print(integer + "\t");
        }
        System.out.println();
        System.out.println("====================");
        for (int i = 0; i < 7; i++) {
            System.out.print(transfer.poll() + "\t");
        }
    }
}
