package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-6-8 9:41
 * 1049. 最后一块石头的重量 II
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1049 {

    public static void main(String[] args) {

    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int w : stones) {
            for (int j = m; j >= w; --j) {
                dp[j] = dp[j] || dp[j - w];
            }
        }
        for (int j = m; ; j--) {
            if (dp[j]) return sum - 2 * j;
        }

//        int n = stones.length, sum = 0;
//        for (int stone : stones) {
//            sum += stone;
//        }
//        int m = sum / 2;
//        boolean[][] dp = new boolean[n + 1][m + 1];
//        dp[0][0] = true;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <= m; j++) {
//                if (stones[i] > j) {
//                    dp[i + 1][j] = dp[i][j];
//                } else {
//                    dp[i + 1][j] = dp[i][j] || dp[i][j - stones[i]];
//                }
//            }
//        }
//        for (int j = m; ; j--) {
//            if (dp[n][j]) {
//                return sum - 2 * j;
//            }
//        }
    }
}
