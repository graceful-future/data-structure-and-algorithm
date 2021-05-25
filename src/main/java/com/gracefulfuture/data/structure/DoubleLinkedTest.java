package com.gracefulfuture.data.structure;

/**
* @description      双链表测试类
* @author           chenkun
* @create           2021/5/25 11:12
* @version          1.0
*/
public class DoubleLinkedTest {
    public static void main(String[] args) {
        DoubleLinked doubleLinked = new DoubleLinked();

        doubleLinked.insert(0,"广州");
        doubleLinked.insertAtFirst("北京");
        doubleLinked.insert(1,"上海");
        doubleLinked.insertAtLast("深圳");
        doubleLinked.insert(3,"香港");
        System.out.println(doubleLinked.isEmpty());
        System.out.println(doubleLinked.size());
        System.out.println(doubleLinked.getData(0));
        System.out.println(doubleLinked.getFirstData());
        System.out.println(doubleLinked.getData(3));
        System.out.println(doubleLinked.getLastData());
    }
}
