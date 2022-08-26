package leetCode;

/**
 * @author hjj
 * @date 2022/8/26 9:16
 * @description 1464. 数组中两元素的最大乘积
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * <p>
 * 请你计算并返回该式的最大值。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1464 {

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int i = 0, j = 1;
        for (int k = 2; k < nums.length; k++) {
            int max = nums[i] > nums[j] ? i : j;
            int min = max == i ? (nums[j] > nums[k] ? k : j) : (nums[i] > nums[k] ? k : i);
            i = i != min ? i : k;
            j = j != min ? j : k;
        }
        return (nums[i] - 1) * (nums[j] - 1);
    }
}
