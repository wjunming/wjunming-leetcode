package com.wjunming.array;

/**
 * @see <a href="https://leetcode.cn/problems/remove-element/description/">27. 移除元素</a>
 */
public class Q27 {

    /**
     * 双指针
     */
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    /**
     * 首尾双指针（最优解）
     */
    public int removeElement2(int[] nums, int val) {
        int left = 0, right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right-- - 1];
            } else {
                left++;
            }
        }
        return left;
    }
}
