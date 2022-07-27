package leetCode;


import java.util.List;

/**
 * 592. 分数加减运算
 * 给定一个表示分数加减运算的字符串?expression?，你需要返回一个字符串形式的计算结果。?
 * <p>
 * 这个结果应该是不可约分的分数，即最简分数。?如果最终结果是一个整数，例如?2，你需要将它转换成分数形式，其分母为?1。所以在上述例子中, 2?应该被转换为?2/1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fraction-addition-and-subtraction
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_592 {

    public static void main(String[] args) {
        Solution_592 solution_592 = new Solution_592();
        System.out.println(solution_592.fractionAddition("5/3+1/3"));
    }

    public String fractionAddition(String expression) {
        if (expression.charAt(0) != '+' && expression.charAt(0) != '-') expression = "+" + expression;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sb.append('G');
            }
            sb.append(expression.charAt(i));
        }
        String[] split = sb.substring(1, sb.length()).split("G");
        String res = "+0/1";
        for (String s : split) {
            res = add(res, s);
        }
        if (res.charAt(0) == '+') return res.substring(1);
        return res;
    }

    public String add(String s1, String s2) {
        String[] s1Arr = s1.split("/");
        String[] s2Arr = s2.split("/");
        int m1 = Integer.parseInt(s1Arr[1]);
        int m2 = Integer.parseInt(s2Arr[1]);
        int m = m1 * m2;
        int z1 = Integer.parseInt(s1Arr[0].substring(1));
        int z2 = Integer.parseInt(s2Arr[0].substring(1));
        int zm1 = s1Arr[0].charAt(0) == '-' ? -1 * (z1 * m2) : (z1 * m2);
        int zm2 = s2Arr[0].charAt(0) == '-' ? -1 * (z2 * m1) : (z2 * m1);
        int zm = zm1 + zm2;
        StringBuilder res = new StringBuilder();
        if (zm >= 0) res.append('+');
        else res.append('-');
        int rev = getRev(m, Math.abs(zm));
        res.append(Math.abs(zm / rev)).append('/').append(m / rev);
        return res.toString();
    }

    public int getRev(int a1, int a2) {
        if (a2 == 0) return a1;
        int max = (Math.min(a1, a2));
        while (max > 1) {
            if (a1 % max == 0 && a2 % max == 0) return max;
            else max--;
        }
        return max;
    }

}
