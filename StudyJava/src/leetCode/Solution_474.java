package leetCode;

/**
 * @author huangjj24
 * @date 2021-6-12 16:55
 * 474. 一和零
 * <p>
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 **/
public class Solution_474 {

    public static void main(String[] args) {
        String[] str = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(str, 5, 3));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int count0 = str.length() - str.replace("0", "").length();
            int count1 = str.length() - str.replace("1", "").length();
            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
