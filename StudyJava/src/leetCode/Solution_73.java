package leetCode;

/**
 * @author huangjj24
 * @date 2021-6-17 17:29
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_73 {

    public static void main(String[] args) {
        int[][] a = {{1, 0, 3}};
        setZeroes(a);
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean h = false, l = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                l = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                h = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (h) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (l) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        // boolean[] h = new boolean[m];
        // boolean[] l = new boolean[n];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == 0) {
        //             h[i] = true;
        //             l[j] = true;
        //         }
        //     }
        // }
        // for (int i = 0; i < m; i++) {
        //     if (h[i]) {
        //         for (int j = 0; j < n; j++) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
        // for (int j = 0; j < n; j++) {
        //     if (l[j]) {
        //         for (int i = 0; i < m; i++) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
    }
}
