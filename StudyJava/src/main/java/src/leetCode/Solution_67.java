package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-6-21 10:42
 * 67. 二进制求和
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 **/
public class Solution_67 {

    public static void main(String[] args) {

    }

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int t = 0;
        while (i >= 0 && j >= 0) {
            int sum = t + (a.charAt(i) - '0') + (b.charAt(j) - '0');
            t = sum / 2;
            builder.append(sum % 2);
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = t + (a.charAt(i) - '0');
            t = sum / 2;
            builder.append(sum % 2);
            i--;
        }
        while (j >= 0) {
            int sum = t + (b.charAt(j) - '0');
            t = sum / 2;
            builder.append(sum % 2);
            j--;
        }
        if (t > 0)
            builder.append(t);
        return builder.reverse().toString();
    }
}
