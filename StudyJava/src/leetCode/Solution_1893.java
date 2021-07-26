package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author huangjj24
 * @date 2021-7-23 8:58
 * 1893. 检查是否区域内所有整数都被覆盖
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 * <p>
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 * <p>
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1893 {

    public static void main(String[] args) {
        Solution_1893 solution_1893 = new Solution_1893();
        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println(solution_1893.isCovered(arr, 2, 5));
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < ranges.length; i++) {
            int r = ranges[i][1];
            if (r >= left && ranges[i][0] <= left) {
                if (ranges[i][1] >= right)
                    return true;
                int j = i + 1;
                while (j < ranges.length && ranges[j][0] <= r + 1) {
                    r = Math.max(r, ranges[j++][1]);
                    if (r >= right)
                        return true;
                }
                return false;
            }
        }
        return false;
    }
}
