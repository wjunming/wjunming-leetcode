package com.wjunming.array;

/**
 * @see <a href="https://leetcode.cn/problems/maximum-area-of-longest-diagonal-rectangle/description">3000. 对角线最长的矩形的面积</a>
 */
public class Q3000 {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDia = 0, maxArea = 0;
        for (int[] dimension : dimensions) {
            int l = dimension[0], w = dimension[1];
            int dia = l * l + w * w;
            if (dia > maxDia) {
                maxDia = dia;
                maxArea = l * w;
            } else if (dia == maxDia) {
                maxArea = Math.max(maxArea, l * w);
            }
        }
        return maxArea;
    }
}
