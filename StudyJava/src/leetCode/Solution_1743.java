package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author hjj199612
 * @date 2021/7/25 10:28 上午
 * @description 1743. 从相邻元素对还原数组
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1743 {

    public static void main(String[] args) {

    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : adjacentPairs) {
            map.putIfAbsent(arr[0], new LinkedList<>());
            map.putIfAbsent(arr[1], new LinkedList<>());
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }
        int n = adjacentPairs.length + 1;
        int[] ret = new int[n];
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            if (e.getValue().size() == 1) {
                ret[0] = e.getKey();
                break;
            }
        }
        ret[1] = map.get(ret[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> ls = map.get(ret[i - 1]);
            ret[i] = ret[i - 2] == ls.get(0) ? ls.get(1) : ls.get(0);
        }
        return ret;
    }
}
