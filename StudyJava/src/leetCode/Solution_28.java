package leetCode;

/**
 * @Description: 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-20 16:29
 **/
public class Solution_28 {
    public static void main(String[] args) {
        System.out.println(strStr("", ""));
    }

    public static int strStr(String haystack, String needle) {
        char[] n = needle.toCharArray(), h = haystack.toCharArray();
        for (int i = 0; i <= h.length - n.length; i++) {
            int j = 0;
            for (; j < n.length && i + j < h.length; j++) {
                if (h[i + j] != n[j]) break;
            }
            if (j == n.length) return i;
        }
        return -1;
//        return haystack.indexOf(needle);
    }
}
