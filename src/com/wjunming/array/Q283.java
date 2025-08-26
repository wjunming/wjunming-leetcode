package com.wjunming.array;

/**
 * @see <a href="https://leetcode.cn/problems/move-zeroes/description/">283. 移动零</a>
 */
public class Q283 {

    /**
     * 双指针（交换元素）
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    /**
     * 双指针
     */
    public void moveZeroes2(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j++) {
                    nums[i] = 0;
                }
            }
        }
    }
}
