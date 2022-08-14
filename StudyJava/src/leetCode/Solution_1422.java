package leetCode;

/**
 * @author hjj199612
 * @date 2022/8/14 4:35 下午
 * @description 1422. 分割字符串的最大得分
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即?左 子字符串和 右 子字符串）所能获得的最大得分。
 * <p>
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-score-after-splitting-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1422 {

    public static void main(String[] args) {
        Solution_1422 solution_1422 = new Solution_1422();
        System.out.println(solution_1422.maxScore("01001"));
    }

    public int maxScore(String s) {
        int num0 = 0, res = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '0') num0++;
        int n0 = 0, i = 0;
        if (s.charAt(i++) == '0') n0++;
        res = n0 + (s.length() - i - (num0 - n0));
        for (; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') n0++;
            int x = n0 + (s.length() - i - 1 - (num0 - n0));
            res = Math.max(x, res);
        }
        return res;
    }
}
