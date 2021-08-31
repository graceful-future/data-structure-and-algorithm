package com.gracefulfuture.algorithm.common;

import java.util.Random;

/**
 * @author chenkun
 * @version 1.0
 * @description 通用算法测试类
 * @create 2021/8/19 14:03
 */
public class CommonAlgorithmTest {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(100) + 1;
        int b = random.nextInt(100) + 1;
        System.out.println("a = " + a + " and b = " + b);
        int result = calMinCommonMultiple(a, b);
        System.out.println("a和b的最小公倍数是：" + result);
        result = lcm(a, b);
        System.out.println("利用最大公约数求a和b的最小公倍数是：" + result);
        result = gcd(a, b);
        System.out.println("欧几里得算法求得a和b的最大公约数是：" + result);
        result = gcd2(a, b);
        System.out.println("辗转相减法求得a和b的最大公约数是：" + result);
        result = gcd3(a, b);
        System.out.println("循环递减法求得a和b的最大公约数是：" + result);
        result = calMaxCommonDivisor(a, b);
        System.out.println("递归求余法求得a和b的最大公约数是：" + result);

    }

    /**
     * @description 欧几里得算法(辗转求余法)求最大公约数
     * @author chenkun
     * @param        a
     * @param        b
     * @date 2021/8/19 14:58
     * @return int
     */
    public static int gcd(int a, int b) {
        int temp = a % b;
        while (temp != 0) {
            a = b;
            b = temp;
            temp = a % b;
        }
        return b;
    }

    /**
     * @description 辗转相减法求最大公约数
     * @author chenkun
     * @param        a
     * @param        b
     * @date 2021/8/19 14:59
     * @return int
     */
    public static int gcd2(int a, int b) {
        while (true) {
            if (a > b) {
                a -= b;
            } else if (a < b) {
                b -= a;
            } else {
                return a;
            }
        }
    }

    /**
     * @description 循环递减法计算最大公约数
     * @author chenkun
     * @param        a
     * @param        b
     * @date 2021/8/19 15:10
     * @return int
     */
    public static int gcd3(int a, int b) {
        int temp = Math.min(a, b);
        while (true) {
            if (a % temp == 0 && b % temp == 0) {
                break;
            } else {
                temp--;
            }
        }
        return temp;
    }

    /**
     * @description 递归求余法计算最大公约数
     * @author chenkun
     * @param        a
     * @param        b
     * @date 2021/8/19 15:16
     * @return int
     */
    public static int calMaxCommonDivisor(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return calMaxCommonDivisor(b, a % b);
    }

    /**
     * @description 利用最大公约数求最小公倍数
     * @author chenkun
     * @param        a
     * @param        b
     * @date 2021/8/19 15:23
     * @return int
     */
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /**
     * @description 计算两个数的最小公倍数
     * @author chenkun
     * @param        a
     * @param        b
     * @date 2021/8/19 14:32
     * @return int
     */
    public static int calMinCommonMultiple(int a, int b) {
        int result = 0;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max % min == 0) {
            return max;
        }
        if ((a + b) % 2 != 0 && gcd(a, b) == 1) {
            return a * b;
        }
        for (int i = max + 1; i <= a * b; i++) {
            if (i % a == 0 && i % b == 0) {
                result = i;
                break;
            }
        }
        return result;
    }


}
