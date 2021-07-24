package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hjj199612
 * @date 2021/7/18 11:45 上午
 * @description 面试题 10.02. 变位词组
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <p>
 * 注意：本题相对原题稍作修改
 */
public class Solution_10_02 {

    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> key = getKey(str);
            List<String> l = map.getOrDefault(key, new ArrayList<>());
            l.add(str);
            map.put(key, l);
        }
        return new ArrayList<>(map.values());
    }

    private Map<Character, Integer> getKey(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
