package leetCode;

/**
 * @author huangjj24
 * @date 2021-7-6 11:08
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 **/
public class Solution_42 {

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution_42 solution_42 = new Solution_42();
        System.out.println(solution_42.trap(a));
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int sum = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                sum += leftMax - height[left++];
            } else {
                sum += rightMax - height[right--];
            }
        }
        return sum;
    }
}
