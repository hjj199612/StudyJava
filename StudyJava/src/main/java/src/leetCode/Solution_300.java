package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-6-24 11:20
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_300 {

    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution_300 solution_300 = new Solution_300();
        System.out.println(solution_300.lengthOfLIS(a));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1)
            return 1;
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;

        // int n = nums.length;
        // int[][] dp = new int[n + 1][n + 1];
        // dp[1][1] = 1;
        // for (int i = 2; i <= n; i++) {
        //     int max = 1;
        //     for (int j = 1; j < i; j++) {
        //         dp[i][j] = dp[i - 1][j];
        //         if (nums[i - 1] > nums[j - 1])
        //             max = Math.max(max, dp[i - 1][j] + 1);
        //     }
        //     dp[i][i] = max;
        // }
        // int res = 0;
        // for (int i : dp[n]) {
        //     res = Math.max(res, i);
        // }
        // return res;
    }
}
