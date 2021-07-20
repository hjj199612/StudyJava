package src.leetCode;

/**
 * @Description:633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * @Author: huangjj24
 * @CreateDate: 2021-4-28 10:59
 **/
public class Solution_633 {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
    }

    public static boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left < right) {
            int x = left * left + right * right;
            if (x == c) return true;
            if (x < c) left++;
            if (x > c) right--;
        }
        return false;

//        int qurtC1 = (int) Math.sqrt(c);
//        for (int i = 0; i <= qurtC1; i++) {
//            int x = c - i * i;
//            if ((int) Math.sqrt(x) == Math.sqrt(x)) return true;
//        }
//        return false;
    }
}
