package com.wjunming.array;

/**
 * @see <a href="https://leetcode.cn/problems/container-with-most-water/description/">11. 盛最多水的容器</a>
 */
public class Q11 {

    /**
     * 两层循环（暴力）
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     * 双指针（最优解）
     */
    public int maxArea2(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int low = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, low * (j - i + 1));
        }
        return max;
    }
}
