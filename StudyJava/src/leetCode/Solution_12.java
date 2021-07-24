package leetCode;

/**
 * @Description: 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-27 9:56
 **/
public class Solution_12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }

    public static String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int values[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String reps[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                builder.append(reps[i]);
                num -= values[i];
            }
        }
        return builder.toString();
//        StringBuilder builder = new StringBuilder();
//        int x = num / 1000;
//        while (x-- > 0) builder.append('M');
//        num %= 1000;
//        x = num / 100;
//        if (x == 9) builder.append("CM");
//        if (x < 9 && x >= 5) {
//            x = x % 5;
//            builder.append('D');
//            while (x-- > 0) builder.append('C');
//        }
//        if (x == 4) builder.append("CD");
//        if (x < 4 && x > 0) while (x-- > 0) builder.append('C');
//        num %= 100;
//        x = num / 10;
//        if (x == 9) builder.append("XC");
//        if (x < 9 && x >= 5) {
//            x = x % 5;
//            builder.append('L');
//            while (x-- > 0) builder.append('X');
//        }
//        if (x == 4) builder.append("XL");
//        if (x < 4 && x > 0) while (x-- > 0) builder.append('X');
//        num %= 10;
//        x = num ;
//        if (x == 9) builder.append("IX");
//        if (x < 9 && x >= 5) {
//            x = x % 5;
//            builder.append('V');
//            while (x-- > 0) builder.append('I');
//        }
//        if (x == 4) builder.append("IV");
//        if (x < 4 && x > 0) while (x-- > 0) builder.append('I');
//        return builder.toString();
    }
}
