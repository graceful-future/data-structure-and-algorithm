package com.gracefulfuture.algorithm.distinct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
* @description      HashSet去重测试类
* @author           chenkun
* @create           2021/6/21 17:05
* @version          1.0
*/
public class HashSetDistinctTest {
    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList(Arrays.asList(1,1,2,3,3,3,4,5,5,6,7));
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer data : list) {
            if(hashSet.add(data)){
                result.add(data);
            }
        }
        System.out.println(result);
    }
}
