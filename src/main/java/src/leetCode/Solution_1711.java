package src.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjj24
 * @date 2021-7-7 8:55
 * 1711. 大餐计数
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * <p>
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * <p>
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * <p>
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-good-meals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1711 {

    public static void main(String[] args) throws InterruptedException {
        // Thread 类的 sleep()和 yield ()方法是静态的？
        Thread.sleep(0);
        Thread.yield ();
    }

    public int countPairs(int[] deliciousness) {
        int count = 0, n = deliciousness.length, mod = 1000000007;
        int maxV = 0;
        for (int num : deliciousness) {
            maxV = Math.max(maxV, num);
        }
        int maxVal = maxV * 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int sum = 1; sum <= maxVal; sum <<= 1) {
                int c = map.getOrDefault(sum - deliciousness[i], 0);
                count = (count + c) % mod;
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return count;
    }
}
