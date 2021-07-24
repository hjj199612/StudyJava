package leetCode;

/**
 * @author huangjj24
 * @date 2021-5-31 9:22
 * 342. 4的幂
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_342 {
    public static void main(String[] args) {

    }

    public boolean isPowerOfFour(int n) {
        if (n < 0) return false;
        while (n > 1) {
            if ((n & 3) != 0) return false;
            n >>= 2;
        }
        return n == 1;
    }
}
