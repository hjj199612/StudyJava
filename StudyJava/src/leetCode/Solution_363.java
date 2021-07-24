package leetCode;

/**
 * @Description:363. 矩形区域不超过 K 的最大数值和
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * <p>
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * @Author: huangjj24
 * @CreateDate: 2021-4-22 11:15
 **/
public class Solution_363 {
    public static void main(String[] args) {

    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int max = Integer.MIN_VALUE;
        int x = matrix.length + 1;
        int y = matrix[0].length + 1;
        int[][] box = new int[x][y];
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                box[i][j] = box[i - 1][j] + box[i][j - 1] - box[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                for (int i1 = i; i1 < x; i1++) {
                    for (int j1 = j; j1 < y; j1++) {
                        int v = box[i1][j1]-box[i-1][j1]-box[i1][j-1]+box[i-1][j-1];
                        if(v<=k) max=v>max?v:max;
                    }
                }
            }
        }
        return max;
    }
}
