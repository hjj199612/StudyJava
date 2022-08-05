package leetCode;

import java.util.Arrays;

/**
 * 899. 有序队列
 * 给定一个字符串 s 和一个整数 k?。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 * <p>
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串?。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/orderly-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_899 {

    public static void main(String[] args) {

    }

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String min = s;
            StringBuilder sb = new StringBuilder(min);
            for (int i = 0; i < s.length(); i++) {
                String substring = sb.append(sb.charAt(0)).substring(1);
                if (min.compareTo(substring) > 0) min = substring;
                sb = new StringBuilder(substring);
            }
            return min;
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }
}
