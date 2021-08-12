package leetCode;

/**
 * @author huangjj24
 * @date 2021-8-12 8:59
 * 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * <p>
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_516 {

    public static void main(String[] args) {
        System.out.println(" DJ118_5 SUS201 T=0.5mm 无表面处理 原色 OEM DJ118 :长*宽*高:430mm*295mm*480mm售后配件 含独立包装 挂板".length());
        System.out.println("装饰罩12av.我".length());
    }

    public int longestPalindromeSubseq(String s) {
        int l = s.length();
        int[][] dp = new int[l][l];
        for (int i = l - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < l; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][l - 1];
    }
}
