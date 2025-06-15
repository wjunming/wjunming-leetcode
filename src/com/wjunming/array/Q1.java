package com.wjunming.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.cn/problems/two-sum/">1. 两数之和</a>
 */
public class Q1 {

    /**
     * 两层循环（暴力）
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * 一层循环哈希（最优解）
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                return new int[]{i, map.get(value)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}
