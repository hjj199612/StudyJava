package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjj24
 * @date 2021-5-28 17:43
 * 22. 括号生成
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 **/
public class Solution_22 {

    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        result.add("");
        return fillResult(result, n, n);
    }

    private List<String> fillResult(List<String> list, int left, int right) {
        if (right == 0) return list;
        if (left == 0) {
            String s = "";
            while (right-- > 0) s += ")";
            List<String> result = new ArrayList<>();
            String finalS = s;
            list.forEach(e -> {
                result.add(e + finalS);
            });
            return result;
        }
        if (left == right) {
            List<String> result = new ArrayList<>();
            list.forEach(e -> {
                result.add(e + "(");
            });
            return fillResult(result, left - 1, right);
        } else {
            List<String> list1 = new ArrayList<>();
            list.forEach(e -> {
                list1.add(e + "(");
            });
            List<String> result1 = fillResult(list1, left - 1, right);
            List<String> list2 = new ArrayList<>();
            list.forEach(e -> {
                list2.add(e + ")");
            });
            List<String> result2 = fillResult(list2, left, right - 1);
            result1.addAll(result2);
            return result1;
        }
    }
}
