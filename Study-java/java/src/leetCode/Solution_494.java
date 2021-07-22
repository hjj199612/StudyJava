package src.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjj24
 * @date 2021-6-7 8:49
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_494 {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(a, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map0 = new HashMap<>();
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                int k3 = e.getKey() + nums[i];
                int k4 = e.getKey() - nums[i];
                map0.put(k3, e.getValue() + map0.getOrDefault(k3, 0));
                map0.put(k4, e.getValue() + map0.getOrDefault(k4, 0));
            }
            map = map0;
        }
        return map.getOrDefault(target, 0);
    }
}
