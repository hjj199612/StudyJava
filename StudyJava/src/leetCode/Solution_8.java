package leetCode;

/**
 * @Description:8. 字符串转换整数 (atoi)请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-22 10:34
 **/
public class Solution_8 {

    public static void main(String[] args) {
        System.out.println(String.valueOf(Integer.MAX_VALUE));
        System.out.println(myAtoi("2000000000000000000000"));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        char[] c = s.toCharArray();
        if (c.length == 0) return 0;
        StringBuilder builder = new StringBuilder();
        if (c[0] == '-' || c[0] == '+' || (c[0] >= '0' && c[0] <= '9')) builder.append(c[0]);
        else return 0;
        for (int i = 1; i < c.length; i++) {
            if (c[i] >= '0' && c[i] <= '9') builder.append(c[i]);
            else break;
        }
        long n=0;
        try {
            n = Long.parseLong(builder.toString());
        }catch (Exception e){
            if (builder.length() == 1 && (builder.charAt(0) > '9' || builder.charAt(0) < '0')) return 0;
            if (builder.length() > 12) return c[0] == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        n = n > Integer.MAX_VALUE ? Integer.MAX_VALUE : n;
        n = n < Integer.MIN_VALUE ? Integer.MIN_VALUE : n;
        return (int) n;
    }

}
