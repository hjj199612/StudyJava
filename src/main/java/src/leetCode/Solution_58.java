package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-6-21 10:54
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_58 {

    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        int len = 0;
        boolean f = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                len++;
                f = true;
            } else if (f)
                break;
        }
        return len;
    }
}
