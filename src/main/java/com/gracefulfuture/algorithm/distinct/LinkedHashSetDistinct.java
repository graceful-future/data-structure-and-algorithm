package com.gracefulfuture.algorithm.distinct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
* @description      LinkedHashSet去重
* @author           chenkun
* @create           2021/6/21 17:02
* @version          1.0
*/
public class LinkedHashSetDistinct {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList(Arrays.asList(1,1,2,3,3,3,4,5,5,6,7));
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet(list);
        System.out.println(linkedHashSet);
    }
}
