package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. 数组序号转换给你一个整数数组?arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * <p>
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * <p>
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 * ?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rank-transform-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1331 {


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 1, 2};
        Solution_1331 solution_1331 = new Solution_1331();
        System.out.println(Arrays.toString(solution_1331.arrayRankTransform(arr)));

    }

    public int[] arrayRankTransform(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 1; i < arrCopy.length; i++) if (!map.containsKey(arrCopy[i])) map.put(arrCopy[i], j++);
        for (int i = 0; i < arr.length; i++) arr[i] = map.get(arr[i]);
        return arr;
    }
}
