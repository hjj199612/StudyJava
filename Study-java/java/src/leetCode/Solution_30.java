package src.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangjj24
 * @date 2021-6-1 11:21
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_30 {

    public static void main(String[] args) {

    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        int oneLength = words[0].length();
        int sumLength = oneLength * words.length;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length()-sumLength+1; i++) {
            String temp = s.substring(i,i+sumLength);
            Map<String,Integer> temp_map = new HashMap<>();
            for (int j = 0; j < sumLength; j+=oneLength) {
                String w = temp.substring(j,j+oneLength);
                temp_map.put(w,temp_map.getOrDefault(w,0)+1);
            }
            if(map.equals(temp_map)) res.add(i);
        }
        return res;
    }
}
