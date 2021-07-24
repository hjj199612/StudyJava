package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjj24
 * @date 2021-6-3 9:30
 * 525. 连续数组
 * <p>
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 **/
public class Solution_525 {

    public static void main(String[] args) {

    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = 0, count1 = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            count1 += nums[i];
            int count1_0 = 2 * count1 - i - 1;
            if (map.containsKey(count1_0)) length = Math.max(length, i - map.get(count1_0));
            else map.put(count1_0, i);
        }
        return length;
    }

}
