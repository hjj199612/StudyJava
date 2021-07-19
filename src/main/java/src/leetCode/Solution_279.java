package src.leetCode;

import java.util.Arrays;

/**
 * @author huangjj24
 * @date 2021-6-11 9:20
 * 279. 完全平方数
 * <p>
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 **/
public class Solution_279 {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; ; i++) {
            int x = i * i;
            if (x <= n)
                for (int j = x; j <= n; j++)
                    dp[j] = Math.min(dp[j], dp[j - x] + 1);
            else
                break;
        }
        return dp[n];
    }
}
