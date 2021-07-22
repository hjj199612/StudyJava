package src.leetCode;

/**
 * @Description:14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author: huangjj24
 * @CreateDate: 2021-4-28 11:29
 **/
public class Solution_14 {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        String s = null;
        System.out.println(builder.append(s).toString());
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; true; i++) {
            char c;
            if (strs[0].length() > i) {
                c = strs[0].charAt(i);
            } else return builder.toString();
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() > i) {
                    if (c != strs[j].charAt(i)) return builder.toString();
                } else return builder.toString();
            }
            builder.append(c);
        }
    }
}
