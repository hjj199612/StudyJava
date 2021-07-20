package src.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-19 14:18
 **/
public class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(target-nums[i])==null) map.put(nums[i],i);
            else {
                int[] twoSum = {i,map.get(target-nums[i])};
                return twoSum;
            }
        }

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if(nums[i]+nums[j]==target&&i!=j){
//                    int[] twoSum = {i,j};
//                    return twoSum;
//                }
//            }
//        }
        return null;
    }

}
