package leetCode;

/**
 * @author huangjj24
 * @date 2021-6-18 17:23
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 **/
public class Solution_53 {

    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int pre = 0,  maxSum = nums[0];
        for (int num : nums) {
            pre = Math.max(pre+num, num);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }
}


