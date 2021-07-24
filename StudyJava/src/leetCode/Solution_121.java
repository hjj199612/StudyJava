package leetCode;

/**
 * @author huangjj24
 * @date 2021-6-14 9:38
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 **/
public class Solution_121 {

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
