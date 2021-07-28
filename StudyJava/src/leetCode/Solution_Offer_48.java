package leetCode;

import java.util.Arrays;

/**
 * @author hjj199612
 * @date 2021/7/28 10:58 下午
 * @description 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class Solution_Offer_48 {

    public static void main(String[] args) {
        Solution_Offer_48 solution_offer_48 = new Solution_Offer_48();
        System.out.println(solution_offer_48.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, len = 0;
        int[] carr = new int[256];
        Arrays.fill(carr, -1);
        while (r < s.length()) {
            char c = s.charAt(r);
            if (carr[c] < l) {
                len = Math.max(len, r - l + 1);
            } else {
                l = carr[c] + 1;
            }
            carr[c] = r;
            r++;
        }
        return len;
    }
}
