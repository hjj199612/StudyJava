package leetCode;

/**
 * @author huangjj24
 * @date 2021-8-8 9:49
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1137 {

    public static void main(String[] args) {

    }

    public int tribonacci(int n) {
        int[] dp = new int[n+3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3;i <= n;i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
}
