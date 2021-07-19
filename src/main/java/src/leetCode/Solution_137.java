package src.leetCode;

/**
 * @Description:137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * @Author: huangjj24
 * @CreateDate: 2021-4-30 15:07
 **/
public class Solution_137 {

    public static void main(String[] args) {
        int[] c = {2, 2, 2, 3};
        System.out.println(singleNumber(c));
    }

    public static int singleNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
                    flag = false;
                    break;
                }
            }
            if (flag) return nums[i];
        }
        return 0;
//        int a = 0, b = 0;
//        for (int num : nums)
//        {
//            a = (a ^ num) & ~b;
//            b = (b ^ num) & ~a;
//        }
//        return a;
    }
}
