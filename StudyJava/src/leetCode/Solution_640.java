package leetCode;


/**
 * 640. 求解方程
 * 求解一个给定的方程，将x以字符串 "x=#value"?的形式返回。该方程仅包含 '+' ， '-' 操作，变量?x?和其对应系数。
 * <p>
 * 如果方程没有解，请返回?"No solution"?。如果方程有无限解，则返回 “Infinite solutions” 。
 * <p>
 * 如果方程中只有一个解，要保证返回值 'x'?是一个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/solve-the-equation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_640 {

    public static void main(String[] args) {
        Solution_640 solution_640 = new Solution_640();
        System.out.println(solution_640.solveEquation("x=x+2"));
    }

    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String left = getString(split[0]);
        String right = getString(split[1]);
        String[] leftArr = left.split(",");
        String[] rightArr = right.split(",");
        int x = Integer.parseInt(leftArr[0]) - Integer.parseInt(rightArr[0]);
        int n = Integer.parseInt(rightArr[1]) - Integer.parseInt(leftArr[1]);
        if (x == 0 && n == 0) return "Infinite solutions";
        else if (x == 0 && n != 0) return "No solution";
        else return "x=" + n / x;
    }

    private String getString(String s) {
        int x = 0, n = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'x') {
                String s1 = sb.toString();
                if ("".equals(s1) || "+".equals(s1)) x += 1;
                else if ("-".equals(s1)) x -= 1;
                else x += Integer.parseInt(s1);
                sb = new StringBuilder();
            } else if (i == s.length() - 1 || '+' == s.charAt(i + 1) || '-' == s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                n += Integer.parseInt(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(s.charAt(i));
            }
        }
        return "" + x + "," + n;
    }
}
