package src.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjj24
 * @date 2021-6-2 8:59
 * 523. 连续的子数组和
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_523 {

    public static void main(String[] args) {
        int[] a = {23, 2, 6, 4, 7};
        System.out.println(checkSubarraySum(a, 13));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {


        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) return true;
            } else {
                map.put(mod, i);
            }
        }
        return false;

        //超时答案
//        long[] sums = new long[nums.length + 1];
//        sums[1] = nums[0];
//        for (int i = 2; i < nums.length + 1; i++) {
//            sums[i] = sums[i - 1] + nums[i - 1];
//        }
//        for (int i = 0; i < sums.length; i++) {
//            for (int j = i + 2; j < sums.length; j++) {
//                if ((sums[j] - sums[i]) % k == 0) return true;
//            }
//        }
//        return false;
    }
}
