package src.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjj24
 * @date 2021-6-23 9:57
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 **/
public class Solution_96 {

    public static void main(String[] args) {
        System.out.println((int) Math.pow(2, 3) - 1);
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    private int count = 0;

    public int numTrees2(int n) {
        // Integer[] arr = new Integer[(int) Math.pow(2, n) - 1];
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ls.add(i);
        }
        for (int i = 1; i <= n; i++) {
            ls.remove(Integer.valueOf(i));
            backTrack(ls, i);
            ls.add(i);
        }
        return count;
    }

    private void backTrack(List<Integer> ls, int root) {
        if (ls.size() == 0) {
            count++;
            return;
        }
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i) < root) {

            }
        }
    }
}
