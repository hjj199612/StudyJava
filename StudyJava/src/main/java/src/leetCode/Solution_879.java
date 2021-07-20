package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-6-9 9:13
 * 879. 盈利计划
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * <p>
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * <p>
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * <p>
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/profitable-schemes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_879 {

    public static void main(String[] args) {


    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = profit.length, MOD = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 0; i < len; i++) {
            int members = group[i], earn = profit[i];
            for (int j = n; j >= members; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - members][Math.max(0, k - earn)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
//        int len = profit.length, MOD = (int) 1e9 + 7, sum = 0;
//        int[][][] dp = new int[len+1][n + 1][minProfit + 1];
//        dp[0][0][0] = 1;
//        for (int i = 1; i <= len; i++) {
//            int members = group[i - 1], earn = profit[i - 1];
//            for (int j = 0; j <= n; j++) {
//                for (int k = 0; k <= minProfit; k++) {
//                    if (members > j) dp[i][j][k] = dp[i - 1][j][k];
//                    else dp[i][j][k] = (dp[i - 1][j][k] + dp[i - 1][j - members][Math.max(0, k - earn)])%MOD;
//                }
//            }
//        }
//        for (int j = 0; j <= n; j++) {
//            sum = (sum + dp[len][j][minProfit]) % MOD;
//        }
//        return sum;
    }
}
