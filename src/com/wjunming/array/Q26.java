package com.wjunming.array;

/**
 * @see <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/">26. 删除有序数组中的重复项</a>
 */
public class Q26 {

    /**
     * 双指针（最优解）
     */
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
