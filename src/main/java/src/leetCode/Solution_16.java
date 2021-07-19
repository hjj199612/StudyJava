package src.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-30 16:52
 **/
public class Solution_16 {

    public static void main(String[] args) {

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int l = nums.length;
        int minDis = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < l; i++) {
            int j = i + 1, k = l - 1;
            while (j < k) {
                int res = nums[i] + nums[j] + nums[k];
                if(res == target) return res;
                int dis = Math.abs(target - res);
                if (dis < minDis) {
                    minDis = dis;
                    result = res;
                }
                if(res>target) k--;
                else j++;
            }
        }
        return result;
    }
}
