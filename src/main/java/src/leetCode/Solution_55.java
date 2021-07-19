package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-6-30 13:43
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 **/
public class Solution_55 {

    public static void main(String[] args) {
        int[] a = {0, 1};
        Solution_55 solution_55 = new Solution_55();
        System.out.println(solution_55.canJump(a));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (nums[j-1] >= i - j && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
