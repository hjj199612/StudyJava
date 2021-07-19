package src.leetCode;

/**
 * @author hjj199612
 * @date 2021/5/30 4:21 下午
 * @description 231. 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_231 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-8));
    }

    public static boolean isPowerOfTwo(int n) {
        return n >0 && Integer.bitCount(n) == 1;
    }
}
