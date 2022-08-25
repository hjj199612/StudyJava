package nowcoder;

import java.util.Scanner;

/**
 * @author hjj
 * @date 2022/8/19 10:15
 * @description HJ42 学英语
 * 描述
 * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 * <p>
 * 具体规则如下:
 * 1.在英语读法中三位数字看成一整体，后面再加一个计数单位。从最右边往左数，三位一单位，例如12,345 等
 * 2.每三位数后记得带上计数单位 分别是thousand, million, billion.
 * 3.公式：百万以下千以上的数 X thousand X, 10亿以下百万以上的数：X million X thousand X, 10 亿以上的数：X billion X million X thousand X. 每个X分别代表三位数或两位数或一位数。
 * 4.在英式英语中百位数和十位数之间要加and，美式英语中则会省略，我们这个题目采用加上and，百分位为零的话，这道题目我们省略and
 * <p>
 * 下面再看几个数字例句：
 * 22: twenty two
 * 100:  one hundred
 * 145:  one hundred and forty five
 * 1,234:  one thousand two hundred and thirty four
 * 8,088:  eight thousand (and) eighty eight (注:这个and可加可不加，这个题目我们选择不加)
 * 486,669:  four hundred and eighty six thousand six hundred and sixty nine
 * 1,652,510:  one million six hundred and fifty two thousand five hundred and ten
 * <p>
 * 说明：
 * 数字为正整数，不考虑小数，转化结果为英文小写；
 * 保证输入的数据合法
 * 关键字提示：and，billion，million，thousand，hundred。
 * <p>
 * 数据范围：1 \le n \le 2000000 \1≤n≤2000000
 */
public class Solution_HJ42 {
    private static String[] arr1 = {"thousand", "million", "billion"};
    private static String[] arr2 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    private static String[] arr3 = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static String[] arr4 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder sb0 = new StringBuilder();
        for (int i = s.length()-1,j=0; i >=0; i--) {
            sb0.append(s.charAt(i));
            if(++j%3==0&&i!=0) {
                sb0.append(',');
            }
        }
        String[] split = sb0.reverse().toString().split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(get3(split[i]));
            if (split.length - i == 1) break;
            sb.append(" ").append(arr1[split.length - i - 2]);
        }
        System.out.println(sb);
    }

    private static String get3(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() == 3) {
            if (s.charAt(0) != '0') {
                sb.append(arr2[s.charAt(0) - '0']).append(" hundred ");
                if (s.charAt(1) != '0' || s.charAt(2) != '0') sb.append("and ");
            }
        }
        sb.append(get2(s));
        return sb.toString();
    }

    private static String get2(String s) {
        if (s.length() == 3) s = s.substring(1);
        if ("00".equals(s)) return "";
        if (s.length() == 2) {
            if (s.charAt(0) == '0') return arr2[s.charAt(1) - '0'];
            else if (s.charAt(0) == '1') return arr3[s.charAt(1) - '0'];
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(arr4[s.charAt(0) - '2']);
                if (s.charAt(1) != '0') sb.append(" ").append(arr2[s.charAt(1) - '0']);
                return sb.toString();
            }
        } else {
            return arr2[s.charAt(0) - '0'];
        }
    }


}
