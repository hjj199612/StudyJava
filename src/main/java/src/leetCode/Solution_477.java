package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-5-28 16:30
 * 477. 汉明距离总和两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * <p>
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 **/
public class Solution_477 {

    public static void main(String[] args) {

    }

    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            int num1 = 0;
            for (int num : nums) {
                num1+=(num>>i)&1;
            }
            sum+=num1*(nums.length-num1);
        }
        return sum;
    }
}
