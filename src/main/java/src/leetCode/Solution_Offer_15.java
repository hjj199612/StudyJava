package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-6-23 8:57
 * 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_Offer_15 {

    public static void main(String[] args) {
        System.out.println(0b11);
        Solution_Offer_15 solution_offer_15 = new Solution_Offer_15();

        System.out.println(Integer.bitCount(0b11111111111111111111111111111101));
        System.out.println(solution_offer_15.hammingWeight(0b11111111111111111111111111111101));
    }

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                count++;
        }
        return count;

        // int count = 0;
        // while (n != 0) {
        //     n &= n - 1;
        //     count++;
        // }
        // return count;

        // return Integer.bitCount(n);
    }
}
