package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-30 17:19
 **/
public class Solution_17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() != 0) list.add("");
        for (int i = 0; i < digits.length(); i++) {
            list = appendChar(list, digits.charAt(i));
        }
        return list;
    }

    public static List<String> appendChar(List<String> list, char c) {
        List<String> result = new ArrayList<>();
        switch (c) {
            case '2':
                list.forEach(e -> {
                    result.add(e + 'a');
                    result.add(e + 'b');
                    result.add(e + 'c');
                });
                break;
            case '3':
                list.forEach(e -> {
                    result.add(e + 'd');
                    result.add(e + 'e');
                    result.add(e + 'f');
                });
                break;
            case '4':
                list.forEach(e -> {
                    result.add(e + 'g');
                    result.add(e + 'h');
                    result.add(e + 'i');
                });
                break;
            case '5':
                list.forEach(e -> {
                    result.add(e + 'j');
                    result.add(e + 'k');
                    result.add(e + 'l');
                });
                break;
            case '6':
                list.forEach(e -> {
                    result.add(e + 'm');
                    result.add(e + 'n');
                    result.add(e + 'o');
                });
                break;
            case '7':
                list.forEach(e -> {
                    result.add(e + 'p');
                    result.add(e + 'q');
                    result.add(e + 'r');
                    result.add(e + 's');
                });
                break;
            case '8':
                list.forEach(e -> {
                    result.add(e + 't');
                    result.add(e + 'u');
                    result.add(e + 'v');
                });
                break;
            case '9':
                list.forEach(e -> {
                    result.add(e + 'w');
                    result.add(e + 'x');
                    result.add(e + 'y');
                    result.add(e + 'z');
                });
                break;
        }
        return result;
    }
}
