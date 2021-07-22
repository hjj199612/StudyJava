package src.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjj24
 * @date 2021-5-29 11:17
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 **/
public class Solution_560 {

    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        //前缀和+哈希表
        int count=0,preSum=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            preSum+=nums[i];
            if(map.containsKey(preSum-k)){
                count+=map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;

//        //暴力算法
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum == k) count++;
//            }
//        }
//        return count;
    }
}
