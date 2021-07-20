package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-6-15 11:20
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 **/
public class Solution_64 {

    public static void main(String[] args) {
        int[][] c = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(c));
        char a[] = new char[2];
        a[1] = '1';
        System.out.println(a[0]);

    }

    public static int minPathSum(int[][] grid) {
        int n = grid.length, l = grid[0].length;
        int[][] dp = new int[n + 1][l + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
                } else if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + grid[i - 1][j - 1];
                } else
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
            }
        }
        return dp[n][l];
    }
}
