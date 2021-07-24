package leetCode;

/**
 * @author huangjj24
 * @date 2021-7-17 10:48
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 **/
public class Solution_Offer_42 {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int sum = nums[0], min = 0, max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, sum);
            sum += nums[i];
            max = Math.max(max, sum - min);
        }
        return max;
    }
}
