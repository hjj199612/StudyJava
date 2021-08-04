package leetCode;

/**
 * @author huangjj24
 * @date 2021-8-3 8:51
 * 581. 最短无序连续子数组
 * <p>
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 **/
public class Solution_581 {

    public static void main(String[] args) {
        Solution_581 solution_581 = new Solution_581();
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(solution_581.findUnsortedSubarray(arr));
    }

    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = nums.length - 1, max = nums[0], min = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                l = i;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) {
                r = i;
            }
        }
        return r >= l ? 0 : l - r + 1;
    }
}
