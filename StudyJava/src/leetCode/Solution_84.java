package leetCode;

/**
 * @author huangjj24
 * @date 2021-6-15 10:09
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 **/
public class Solution_84 {

    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        int maxA = 0;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            maxA = Math.max(maxA, h);
            for (int j = i; j < heights.length; j++) {
                h = Math.min(h, heights[j]);
                maxA = Math.max(maxA, h * (j - i + 1));
            }
        }
        return maxA;
    }
}
