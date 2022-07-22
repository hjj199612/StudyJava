package leetCode;


import java.util.Arrays;

/**
 * 757. 设置交集大小至少为2
 * 一个整数区间?[a, b]??(?a < b?) 代表着从?a?到?b?的所有连续整数，包括?a?和?b。
 * <p>
 * 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。
 * <p>
 * 输出这个最小集合S的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/set-intersection-size-at-least-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_757 {

    public static void main(String[] args) {


    }

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[1] > e2[1] ? 1 : (e1[1] == e2[1] ? (e1[0] - e2[0]) : -1));
        int res = 2, v1 = intervals[0][1] - 1, v2 = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > v2) {
                res += 2;
                v1 = intervals[i][1]-1;
                v2 = intervals[i][1];
            } else if (v1 < intervals[i][0] && intervals[i][0] <= v2) {
                if (v2 < intervals[i][1]) {
                    v1 = v2;
                    v2 = intervals[i][1];
                } else {
                    v1 = intervals[i][1] - 1;
                }
                res++;
            }
        }
        return res;
    }
}
