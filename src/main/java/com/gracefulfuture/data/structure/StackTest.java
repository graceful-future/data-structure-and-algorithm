package com.gracefulfuture.data.structure;

import java.util.Stack;

/**
* @description      栈测试类
* @author           chenkun
* @create           2021/5/25 11:39
* @version          1.0
*/
public class StackTest {
    public static void main(String[] args) {
        //继承于Vector,底层采用数组作为存储结构
        Stack<String> stack = new Stack();
        stack.add("10");
        stack.add("20");
        stack.add("30");
//        System.out.println(stack.size());
//        System.out.println(stack.pop());
//        System.out.println(stack.size());
//        System.out.println(stack.pop());
//        System.out.println(stack.size());
//        System.out.println(stack.peek());
//        System.out.println(stack.size());
//        System.out.println(stack.peek());
//        System.out.println(stack.size());
//        System.out.println(stack.search("30"));
//        System.out.println(stack.search("20"));
//        System.out.println(stack.empty());
        System.out.println(stack.push("40"));
        System.out.println(stack.peek());
        System.out.println("-----------------");
        stack.stream().forEach(e -> System.out.println(e));
    }
}
