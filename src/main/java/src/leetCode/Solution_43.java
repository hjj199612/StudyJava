package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-6-17 19:42
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 **/
public class Solution_43 {

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        String res = "0";
        int n = num1.length() - 1;
        for (int i = n; i >= 0; i--) {
            StringBuilder s = new StringBuilder();
            for (int j = i; j < n; j++) {
                s.append(0);
            }
            int r = 0;
            int y = (num1.charAt(i) - '0');
            for (int j = num2.length() - 1; j >= 0; j--) {
                int x = (num2.charAt(j) - '0') * y + r;
                s.append(x % 10);
                r = x / 10;
            }
            if (r > 0)
                s.append(r);
            res = getSum(res, s.reverse().toString());
        }
        return res;
    }

    public static String getSum(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
