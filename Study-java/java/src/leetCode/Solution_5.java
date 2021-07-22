package src.leetCode;

/**
 * @Description:给你一个字符串 s，找到 s 中最长的回文子串
 * @Author: huangjj24
 * @CreateDate: 2021-4-20 17:09
 **/
public class Solution_5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int l = c.length;
        for (; l > 0; l--) {
            for (int i = 0; i + l <= c.length; i++) {
                int j = i, k = i + l - 1;
                for (; j < k; j++, k--) {
                    if (c[j] != c[k]) break;
                }
                if (j >= k) return s.substring(i, i + l);
            }
        }
        return String.valueOf(c[0]);
    }

    public static String longestPalindrome(char[] c, int start, int end) {
        StringBuilder builder = new StringBuilder();
        while (start < end) {
            builder.append(c[start++]);
        }
        return builder.toString();
    }
}
