package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-23 9:36
 **/
public class Solution_368 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 8};
        System.out.println(largestDivisibleSubset(nums));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) return list;
        int[] dp = new int[nums.length];
        int maxIndex = 0;
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        }
        int num = dp[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (nums[maxIndex] % nums[i] == 0 && num == dp[i]) {
                list.add(nums[i]);
                num--;
                maxIndex = i;
            }
        }
        return list;
    }

}
