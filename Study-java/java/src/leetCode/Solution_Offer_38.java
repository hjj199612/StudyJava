package src.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huangjj24
 * @date 2021-6-22 10:10
 * 剑指 Offer 38. 字符串的排列
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 **/
public class Solution_Offer_38 {

    public static void main(String[] args) {
        Solution_Offer_38 c = new Solution_Offer_38();
        String[] abcs = c.permutation("abc");
        System.out.println(abcs);
    }

    public String[] permutation(String s) {
        Set<String> set = new HashSet<>();
        dfs(new StringBuilder(), set, 0, s.toCharArray());
        String[] res = new String[set.size()];
        return set.toArray(res);
    }

    private void dfs(StringBuilder s, Set<String> set, int start, char[] chars) {
        if (s.length() == chars.length) {
            set.add(s.toString());
            return;
        }
        for (int i = start; i < chars.length; i++) {
            char c = chars[i];
            chars[i] = chars[start];
            chars[start] = c;
            s.append(c);
            dfs(s, set, start + 1, chars);
            s.deleteCharAt(start);
            chars[start] = chars[i];
            chars[i] = c;
        }
    }
}
