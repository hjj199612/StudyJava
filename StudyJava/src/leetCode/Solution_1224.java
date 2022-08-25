package leetCode;


import java.util.*;

/**
 * 1224. 最大相等频率
 * 给你一个正整数数组?nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
 * <p>
 * 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-equal-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1224 {

    public static void main(String[] args) {
        Solution_1224 solution_1224 = new Solution_1224();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        System.out.println(solution_1224.maxEqualFreq(arr));
    }

    public int maxEqualFreq(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        Map<Integer, Integer> set = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> value = entry.getValue();
                int num = value.size();
                for (int j = value.size() - 1; j >= 0; j--) {
                    if (value.get(j) > i) num--;
                    else break;
                }
                if (num != 0) {
                    if (!set.containsKey(num)) set.put(num, 0);
                    set.put(num, set.get(num) + 1);
                }
                if (set.size() > 2) break;
            }
            if (set.size() == 1 && (set.containsKey(1) || set.containsValue(1))) return i + 1;
            if (set.size() == 2) {
                Map.Entry<Integer, Integer>[] arr = set.entrySet().toArray(new Map.Entry[2]);
                Integer key0 = Math.min(arr[0].getKey(), arr[1].getKey());
                Integer key1 = Math.max(arr[0].getKey(), arr[1].getKey());
                if (key0 == 1) {
                    if (set.get(key0) == 1 || (key1 == 2 && set.get(key1) == 1)) return i + 1;
                } else if (key1 - key0 == 1 && arr[1].getValue() == 1) return i + 1;
            }
            set = new HashMap<>();
        }
        return 0;
    }
}
