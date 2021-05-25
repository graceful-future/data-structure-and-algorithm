package com.gracefulfuture.data.structure;

import java.util.ArrayList;
import java.util.List;

/**
* @description      单链表测试类
* @author           chenkun
* @create           2021/5/24 17:51
* @version          1.0
*/
public class SingleLinkedTest {
    public static void main(String[] args) {
        SingleLinked<String> singleLinked = new SingleLinked<>();
        singleLinked.insertAtFirst("one");
        singleLinked.insertAtLast("infinite");
        singleLinked.insert(1,"four");
        singleLinked.insert(1,"two");
        singleLinked.insert(4,"three");
        System.out.println(singleLinked.size());
        System.out.println(singleLinked.getFirstData());
        System.out.println(singleLinked.getLastData());
        System.out.println(singleLinked.getData(0));
        System.out.println(singleLinked.getData(1));
        System.out.println(singleLinked.getData(2));
        System.out.println(singleLinked.getData(3));
//        List<String> list = new ArrayList<>();
//        list.add(1,"hello");
    }
}
