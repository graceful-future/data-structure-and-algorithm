package com.gracefulfuture.algorithm.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author chenkun
 * @version 1.0
 * @description 素数测试类
 * @create 2021/8/19 15:32
 */
public class PrimeNumberTest {
    public static void main(String[] args) {
        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//            int data = random.nextInt(100) + 1;
//            boolean flag = judgeWhetherPrimeNumber(data);
//            System.out.println(flag ? data + "是素数" : data + "不是素数");
//        }
//        System.out.println(3 >> 1);
        for (int i = 0; i < 100; i++) {
            int data = random.nextInt(1000) + 1;
            boolean success = judgeWhetherPalindromeNumber(data);
            System.out.println(success ? data + "是回文数" : data + "不是回文数");
        }
    }

    /**
     * @description 判断一个数是否是素数
     * @author chenkun
     * @param        data
     * @date 2021/8/19 15:53
     * @return boolean
     */
    public static boolean judgeWhetherPrimeNumber(long data) {
        if (data < 2) {
            return false;
        }
        if (data == 2) {
            return true;
        }
        if (data % 2 == 0) {
            return false;
        }
        int max = (int) Math.sqrt(data);
        for (int i = 3; i <= max; i += 2) {
            if (data % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @description 判断一个数是否为回文数
     * @author chenkun
     * @param        data
     * @date 2021/8/19 16:07
     * @return boolean
     */
    public static boolean judgeWhetherPalindromeNumber(int data) {
        List<Integer> bitList = new ArrayList<>();
        int quotient = data;
        while (quotient != 0) {
            int mod = quotient % 10;
            bitList.add(mod);
            quotient = quotient / 10;
        }

        for (int i = 0; i < bitList.size() >> 1; i++) {
            if (bitList.get(i) != bitList.get(bitList.size() - 1 - i)) {
                return false;
            }
        }
//        System.out.println(bitList);
        return true;
    }
}
