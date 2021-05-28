package com.gracefulfuture.data.structure.queue;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
* @description      SynchronousQueue测试类
* @author           chenkun
* @create           2021/5/28 9:56
* @version          1.0
*/
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        //不允许null元素，多线程同步阻塞
        SynchronousQueue<Integer> synchronous = new SynchronousQueue<>();
//        synchronous.add(null);
//        synchronous.put(10);
//        System.out.println(synchronous.take());
//        System.out.println(synchronous.poll());
//        System.out.println(synchronous.size());
        Runnable runnable1 = new MyThread1(synchronous);
        Runnable runnable2 = new MyThread2(synchronous);
        Thread producer = new Thread(runnable1);
        Thread consumer = new Thread(runnable2);
        consumer.start();
        producer.start();
    }
}
//生产者线程
class MyThread1 implements Runnable{

    private SynchronousQueue<Integer> synchronous = null;

    public MyThread1() {
    }

    public MyThread1(SynchronousQueue<Integer> synchronous) {
        this.synchronous = synchronous;
    }

    @Override
    public void run() {
        int rand = new Random().nextInt(1000);
        System.out.println(String.format("模拟生产者：%d",rand));
        try{
            TimeUnit.SECONDS.sleep(3);
            synchronous.put(rand);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(synchronous.isEmpty());

    }
}
//消费者线程
class MyThread2 implements Runnable{
    private SynchronousQueue<Integer> synchronous = null;

    public MyThread2() {
    }

    public MyThread2(SynchronousQueue<Integer> synchronous) {
        this.synchronous = synchronous;
    }

    @Override
    public void run() {
        System.out.println("消费者已经准备好接受元素了...");
        try{
            System.out.println(String.format("消费一个元素：%d", synchronous.take()));
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("------------------------------------------");
    }
}
