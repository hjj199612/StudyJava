package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-5-27 9:42
 * 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 **/
public class Solution_461 {

    public static void main(String[] args) {

    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);

//        x ^= y;
//        y = 0;
//        while (x > 0) {
//            if ((x & 1) == 1) y++;
//            x >>= 1;
//        }
//        return y;
    }
}
