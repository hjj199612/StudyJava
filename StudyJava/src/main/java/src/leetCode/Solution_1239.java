package src.leetCode;

import java.util.List;

/**
 * @author huangjj24
 * @date 2021-6-19 10:18
 * 1239. 串联字符串的最大长度
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * <p>
 * 请返回所有可行解 s 中最长长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1239 {

    public static void main(String[] args) {

    }

    private int ans;

    public int maxLength(List<String> arr) {
        dfs(arr, 0, new StringBuilder(""));
        return ans;
    }

    private void dfs(List<String> arr, int start, StringBuilder builder) {
        if (!match(builder))
            return;
        ans = Math.max(ans, builder.length());
        int size = arr.size();
        for (int i = start; i < size; i++) {
            builder.append(arr.get(i));
            dfs(arr, i + 1, builder);
            builder.delete(builder.length() - arr.get(i).length(), builder.length());
        }
    }

    private boolean match(StringBuilder builder) {
        String s = builder.toString();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            arr[c]++;
            if (arr[c] > 1)
                return false;
        }
        return true;
    }
}
