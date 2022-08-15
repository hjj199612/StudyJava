package leetCode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 1413. 逐步求和得到正数的最小值
 * 给你一个整数数组 nums?。你可以选定任意的?正数 startValue 作为初始值。
 * <p>
 * 你需要从左到右遍历 nums?数组，并将 startValue 依次累加上?nums?数组中的值。
 * <p>
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的?正数?作为 startValue 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1413 {

    public static void main(String[] args) {

    }

    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(sum, min);
        }
        return min > 0 ? 1 : 1 - min;
    }
}
