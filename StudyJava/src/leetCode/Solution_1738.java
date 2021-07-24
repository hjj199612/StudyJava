package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author huangjj24
 * @date 2021-5-19 11:37
 * 1738. 找出第 K 大的异或坐标值
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * <p>
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * <p>
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1738 {
    public static void main(String[] args) {

    }

    public int kthLargestValue(int[][] matrix, int k) {
        int[][] res = new int[matrix.length + 1][matrix[0].length + 1];
        res[1][1] = matrix[0][0];
        //初始化结果
        List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                res[i][j] = res[i - 1][j] ^ res[i][j - 1] ^ res[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                result.add(res[i][j]);
            }
        }
        Collections.sort(result, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        return result.get(k - 1);

    }
}
