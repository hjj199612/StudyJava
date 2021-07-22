package src.leetCode;

/**
 * @Description:6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-21 11:17
 **/
public class Solution_6 {
    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int l = s.length();
        int index = 0;
        Character[][] c = new Character[numRows][l];
        int i = 0, j = 0;
        while (index < l) {
            while (i < numRows && index < l) {
                c[i][j] = s.charAt(index);
                i++;
                index++;
            }
            i--;
            while (i > 0 && index < l) {
                i--;
                j++;
                c[i][j] = s.charAt(index);
                index++;
            }
            i++;
        }
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            for (int m = 0; m < l; m++) {
                if (c[k][m] != null) builder.append(c[k][m]);
            }
        }
        return builder.toString();
    }
}
