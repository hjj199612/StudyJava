package leetCode;

import java.util.Arrays;

/**
 * @author huangjj24
 * @date 2021-8-9 8:51
 * 313. 超级丑数
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * <p>
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * <p>
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_313 {

    public static void main(String[] args) {
        Solution_313 solution_313 = new Solution_313();
        int[] a = {2, 7, 13, 19};
        System.out.println(solution_313.nthSuperUglyNumber(12, a));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        Arrays.sort(primes);
        int[] dp = new int[n];
        int m = primes.length;
        dp[0] = 1;
        int[] pointers = new int[m];
        Arrays.fill(pointers, 0);
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            int[] nums = new int[m];
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                dp[i] = Math.min(dp[i], nums[j]);
            }
            for (int j = 0; j < m; j++) {
                if (nums[j] <= dp[i]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
