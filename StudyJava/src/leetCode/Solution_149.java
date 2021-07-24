package leetCode;


import java.util.HashMap;
import java.util.Map;

/**
 * @author huangjj24
 * @date 2021-6-24 9:35
 * 149. 直线上最多的点数
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 **/
public class Solution_149 {

    public static void main(String[] args) {
        double x = (double) 2 / 0;
        System.out.println(String.valueOf(2 - 3 * x) + 1);
        Solution_149 solution_149 = new Solution_149();
        int[][] a = {{7, 3}, {19, 19}, {-16, 3}, {13, 17}, {-18, 1}, {-18, -17}, {13, -3}, {3, 7}, {-11, 12}, {7, 19},
                {19, -12}, {20, -18}, {-16, -15}, {-10, -15}, {-16, -18}, {-14, -1}, {18, 10}, {-13, 8}, {7, -5},
                {-4, -9}, {-11, 2}, {-9, -9}, {-5, -16}, {10, 14}, {-3, 4}, {1, -20}, {2, 16}, {0, 14}, {-14, 5},
                {15, -11}, {3, 11}, {11, -10}, {-1, -7}, {16, 7}, {1, -11}, {-8, -3}, {1, -6}, {19, 7}, {3, 6},
                {-1, -2}, {7, -3}, {-6, -8}, {7, 1}, {-15, 12}, {-17, 9}, {19, -9}, {1, 0}, {9, -10}, {6, 20},
                {-12, -4}, {-16, -17}, {14, 3}, {0, -1}, {-18, 9}, {-15, 15}, {-3, -15}, {-5, 20}, {15, -14}, {9, -17},
                {10, -14}, {-7, -11}, {14, 9}, {1, -1}, {15, 12}, {-5, -1}, {-17, -5}, {15, -2}, {-12, 11}, {19, -18},
                {8, 7}, {-5, -3}, {-17, -1}, {-18, 13}, {15, -3}, {4, 18}, {-14, -15}, {15, 8}, {-18, -12}, {-15, 19},
                {-9, 16}, {-9, 14}, {-12, -14}, {-2, -20}, {-3, -13}, {10, -7}, {-2, -10}, {9, 10}, {-1, 7}, {-17, -6},
                {-15, 20}, {5, -17}, {6, -6}, {-11, -8}};
        System.out.println(solution_149.maxPoints(a));

        int m =14,n=7;
        int s = solution_149.gcd(m,n);
        System.out.println(s);

    }

    public int maxPoints(int[][] points) {
        if (points.length <= 2)
            return points.length;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
                int maxn = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int num = entry.getValue();
                    maxn = Math.max(maxn, num + 1);
                }
                max = Math.max(max, maxn);
            }
        }
        return max;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
