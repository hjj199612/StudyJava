package src.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjj24
 * @date 2021-7-8 9:32
 * 930. 和相同的二元子数组
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 **/
public class Solution_930 {

    public static void main(String[] args) {
        Solution_930 solution_930 = new Solution_930();
        int[] a = {1, 0, 1, 0, 1};
        System.out.println(solution_930.numSubarraysWithSum(a, 2));
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(sum - goal, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    int count = 0;

    public int numSubarraysWithSum1(int[] nums, int goal) {
        backTrack(nums, 0, goal);
        return count;
    }

    private void backTrack(int[] nums, int start, int goal) {
        if (goal == 0) {
            count++;
            return;
        }
        for (int i = start; i < nums.length; i++) {
            goal -= nums[i];
            backTrack(nums, i + 1, goal);
            goal += nums[i];
        }
    }
}
