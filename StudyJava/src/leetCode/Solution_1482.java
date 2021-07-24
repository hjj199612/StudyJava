package leetCode;

/**
 * @author hjj199612
 * @date 2021/5/9 8:55 下午
 * @description 1482. 制作 m 束花所需的最少天数
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * <p>
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * <p>
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 * <p>
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1482 {

    public static void main(String[] args) {

    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;
        int maxDay = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            maxDay = Math.max(maxDay, bloomDay[i]);
        }
        int left = 0, right = maxDay;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = getCount(bloomDay, mid, k);
            if (count >= m) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private int getCount(int[] bloomDay, int day, int k) {
        int count = 0, res = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) res++;
            else res = 0;
            if (res == k) {
                res = 0;
                count++;
            }
        }
        return count;
    }
}
