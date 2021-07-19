package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-6-29 10:49
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_45 {

    public static void main(String[] args) {
        Solution_45 solution_45 = new Solution_45();
        int[] a = {2, 3, 1, 1, 4};
        System.out.println(solution_45.jump(a));
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j > 0; j--) {
                if (nums[j - 1] >= i - j) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n];
    }
}
