package leetCode;

/**
 * @Description: 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-21 9:23
 **/
public class Solution_91 {

    public static void main(String[] args) {
        System.out.println(numDecodings("27"));
    }

    public static int numDecodings(String s) {
        char[] c = s.toCharArray();
        int[] sum = new int[c.length + 1];
        if (c[0] == '0') return 0;
        sum[1] = 1;
        if (c.length > 1) {
            if (numDecodings(c, 1)) sum[2]++;
            if (c[1] != '0') sum[2]++;
        }
        for (int i = 3; i <= c.length; i++) {
            boolean bool1 = numDecodings(c, i - 1);
            boolean bool2 = c[i - 1] != '0';
            if (!bool1 && !bool2) return 0;
            if (bool2) sum[i] = sum[i - 1];
            if (bool1) sum[i] += sum[i - 2];
        }
        return sum[c.length];
    }

    public static boolean numDecodings(char[] c, int i) {
        if (c[i - 1] == '0') {
            return false;
        } else {
            int v = Integer.parseInt(String.valueOf(c[i - 1]) + c[i]);
            if (v <= 26) return true;
            else return false;
        }
    }

}
