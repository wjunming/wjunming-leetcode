package com.wjunming.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/climbing-stairs/">70. 爬楼梯</a>
 */
public class Q70 {

    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 缓存 + 递归
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int sum = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, sum);
        return sum;
    }

    /**
     * 动态规划
     */
    public int climbStairs2(int n) {
        if (n < 2) {
            return n;
        }
        int one = 1, two = 2;
        for (int i = 3; i <= n; i++) {
            int three = one + two;
            one = two;
            two = three;
        }
        return two;
    }
}
