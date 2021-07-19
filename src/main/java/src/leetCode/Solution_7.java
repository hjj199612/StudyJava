package src.leetCode;

/**
 * @Description:给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-21 17:43
 **/
public class Solution_7 {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
        long n = 0x7fffffff;
        System.out.println((int) n);
    }

    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return n > Integer.MAX_VALUE || n < Integer.MIN_VALUE ? 0 : (int) n;
//        String s = String.valueOf(x);
//        char[] c = s.toCharArray();
//        StringBuilder builder = new StringBuilder();
//        for (int i = c.length - 1; i > 0; i--) {
//            builder.append(c[i]);
//        }
//        if (c[0] == '-') builder.insert(0, c[0]);
//        else builder.append(c[0]);
//        try{
//            x = Integer.parseInt(builder.toString());
//        }catch (Exception e){
//            return 0;
//        }
//        return x;
    }
}
