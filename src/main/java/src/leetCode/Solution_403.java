package src.leetCode;

/**
 * @Description:403. 青蛙过河
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 * <p>
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 * <p>
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 * <p>
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/frog-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-29 11:29
 **/
public class Solution_403 {

    public static void main(String[] args) {
        int[] a = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(canCross(a));
        boolean[][] b = new boolean[1][1];
        System.out.println(b[0][0]);
        char[][] c = new char[1][1];
        System.out.println(c[0][0]);

    }

    public static boolean canCross(int[] stones) {
        int l = stones.length;
        boolean[][] dp = new boolean[l][l + 1];
        dp[0][1] = true;
        for (int i = 1; i < l; i++) {
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                int diff = stones[i] - stones[j];
                if(diff>i+1) break;
                if (dp[j][diff]) {
                    dp[i][diff - 1] = true;
                    dp[i][diff] = true;
                    dp[i][diff + 1] = true;
                    flag = true;
                }
            }
            if (!flag && i == l - 1) return false;
        }
        return true;
//        int[][] bs = new int[stones.length][stones.length];
//        return canCross(bs, stones, 0, 0);
    }

    public static boolean canCross(int[][] bs, int[] stones, int i, int k) {
        if (i == stones.length - 1) return true;
        if (k - 1 > 0 && bs[i][k - 1] == 0) {
            bs[i][k - 1] = -1;
            int a = i + 1;
            while (a < stones.length && stones[a] - stones[i] <= k - 1) {
                if (stones[a] - stones[i] == k - 1) {
                    bs[i][k - 1] = a;
                    break;
                }
                a++;
            }
        }
        if (bs[i][k] == 0) {
            bs[i][k] = -1;
            int b = i + 1;
            while (b < stones.length && stones[b] - stones[i] <= k) {
                if (stones[b] - stones[i] == k) {
                    bs[i][k] = b;
                    break;
                }
                b++;
            }
        }
        if (bs[i][k + 1] == 0) {
            bs[i][k + 1] = -1;
            int c = i + 1;
            while (c < stones.length && stones[c] - stones[i] <= k + 1) {
                if (stones[c] - stones[i] == k + 1) {
                    bs[i][k + 1] = c;
                    break;
                }
                c++;
            }
        }
        if (bs[i][k + 1] == -1 && bs[i][k] == -1 && (k - 1 > 0 && bs[i][k - 1] == -1)) return false;
        return ((bs[i][k + 1] != -1 && canCross(bs, stones, bs[i][k + 1], k + 1)
                || (bs[i][k] != -1 && canCross(bs, stones, bs[i][k], k)) ||
                k - 1 > 0 && bs[i][k - 1] != -1 && canCross(bs, stones, bs[i][k - 1], k - 1))
        );
    }
}
