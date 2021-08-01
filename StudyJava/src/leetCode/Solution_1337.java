package leetCode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author hjj199612
 * @date 2021/8/1 10:58 上午
 * @description 1337. 矩阵中战斗力最弱的 K 行
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * <p>
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * <p>
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * <p>
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1337 {

    public static void main(String[] args) {

    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < m; j++) {
                arr[i] += mat[i][j];
            }
            arr[i] = arr[i] * 100 + i;
        }
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i] % 100;
        }
        return res;
    }

}
