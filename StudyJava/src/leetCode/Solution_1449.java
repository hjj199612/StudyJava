package leetCode;

/**
 * @author huangjj24
 * @date 2021-6-12 13:51
 * 1449. 数位成本和为目标值的最大数字
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 * <p>
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。
 * 由于答案可能会很大，请你以字符串形式返回。
 * <p>
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1449 {

    public static void main(String[] args) {
        int[] cost = {4, 3, 2, 5, 6, 7, 2, 5, 5};
        System.out.println(largestNumber(cost, 9));
    }

    public static String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        dp[0] = "";
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < cost.length; j++) {
                if (i >= cost[j])
                    dp[i] = getMax(dp[i], dp[i - cost[j]], (j + 1));
            }
        }
        return dp[target] == null ? "0" : dp[target];
    }

    private static String getMax(String s0, String s1, int x) {
        if (s1 == null)
            return s0;
        s1 += x;
        if (s0 == null)
            return s1;
        else if (s1.length() > s0.length())
            return s1;
        else if (s1.length() < s0.length())
            return s0;
        else if (s0.compareTo(s1) > 0)
            return s0;
        else
            return s1;
    }
}
