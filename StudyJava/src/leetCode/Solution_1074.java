package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjj24
 * @date 2021-5-29 10:10
 * 1074. 元素和为目标值的子矩阵数量
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 * <p>
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 * <p>
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1074 {

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1, 0, 1}, {0, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 0, 0}};
        System.out.println(numSubmatrixSumTarget(arr, 0));
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) {
                for (int c = 0; c < n; ++c) {
                    sum[c]+=matrix[j][c];
                }
                count+=getCount(sum,target);
            }
        }
        return count;
        //暴力算法 超时
//        int sum = 0;
//        int x = matrix[0].length + 1;
//        int y = matrix.length + 1;
//        Map<String, Integer> map = new HashMap<>();
//        map.getOrDefault("1",0);
//        for (int x1 = 1; x1 < x; x1++) {
//            for (int x2 = x1; x2 < x; x2++) {
//                for (int y1 = 1; y1 < y; y1++) {
//                    for (int y2 = y1; y2 < y; y2++) {
//                        String key = "" + x1 + "," + x2 + "," + y1 + "," + y2;
//                        String keyX = "" + x1 + "," + (x2 - 1) + "," + y1 + "," + y2;
//                        String keyY = "" + x1 + "," + x2 + "," + y1 + "," + (y2 - 1);
//                        String keyXY = "" + x1 + "," + (x2 - 1) + "," + y1 + "," + (y2 - 1);
//                        Integer keyInt = (map.get(keyX) == null ? 0 : map.get(keyX))
//                                + (map.get(keyY) == null ? 0 : map.get(keyY))
//                                - (map.get(keyXY) == null ? 0 : map.get(keyXY)) + matrix[y2 - 1][x2 - 1];
//                        if (keyInt == target) sum++;
//                        map.put(key, keyInt);
//                    }
//                }
//            }
//        }
//        return sum;
    }

    private static int getCount(int[] sum, int target) {
        int preSum =0;
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < sum.length; i++) {
            preSum+=sum[i];
            if(map.containsKey(preSum-target)){
                count+=map.get(preSum-target);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}
