package com.wjunming.array;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.cn/problems/merge-sorted-array/description/">88. 合并两个有序数组</a>
 */
public class Q88 {

    /**
     * 直接合并+排序
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 双指针
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[nums1.length];
        int p1 = 0, p2 = 0, cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] <= nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            arr[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = arr[i];
        }
    }

    /**
     * 逆向双指针
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, pos = nums1.length - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[pos--] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[pos--] = nums1[p1--];
            } else if (nums1[p1] <= nums2[p2]) {
                nums1[pos--] = nums2[p2--];
            } else {
                nums1[pos--] = nums1[p1--];
            }
        }
    }
}
