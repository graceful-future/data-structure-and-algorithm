package com.gracefulfuture.algorithm.distinct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @description      双重List去重
* @author           chenkun
* @create           2021/6/22 9:10
* @version          1.0
*/
public class DoubleListDistinct {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList(Arrays.asList(1,1,2,3,3,3,4,5,5,6,7));
        List<Student> list = new ArrayList();
        Student s1 = new Student("jack",28);
        Student s2 = new Student("jack",30);
        list.add(s1);
        list.add(s2);
        List<Student> result = new ArrayList<>(list.size());
        list.forEach(e -> {
            if(!result.contains(e)){
                result.add(e);
            }
        });
        System.out.println(result);
        System.out.println(s1.equals(s2));
    }
}
