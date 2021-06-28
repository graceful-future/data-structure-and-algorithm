package com.gracefulfuture.algorithm.distinct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
* @description      Java的集合类流去重
* @author           chenkun
* @create           2021/6/22 9:14
* @version          1.0
*/
public class Java8StreamDistict {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList(Arrays.asList(1,1,2,3,3,3,4,5,5,6,7));
//        List<Integer> result = list.stream().distinct().collect(Collectors.toList());
        List<Student> list = new ArrayList();
        Student s1 = new Student("jack",28);
//        Student s2 = new Student("jack",30);
        Student s2 = s1;
        list.add(s1);
        list.add(s2);
        List<Student> result = new ArrayList<>(list.size());
        result = list.stream().distinct().collect(Collectors.toList());
        System.out.println(result);
    }
}
