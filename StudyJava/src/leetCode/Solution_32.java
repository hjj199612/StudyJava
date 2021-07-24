package leetCode;

import java.util.Stack;

/**
 * @author huangjj24
 * @date 2021-6-4 10:27
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 **/
public class Solution_32 {

    public static void main(String[] args) {

    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
