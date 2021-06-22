package com.gracefulfuture.algorithm.distinct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @description      双重for循环去重
* @author           chenkun
* @create           2021/6/21 16:52
* @version          1.0
*/
public class DoubleForLoopTest {
    public static void main(String[] args) {
//        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList(Arrays.asList(1,1,2,3,3,3,4,5,5,6,7));
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(i != j && list.get(i) == list.get(j)){
                    list.remove(list.get(j));
                }
            }
        }
        System.out.println(list);
    }
}
