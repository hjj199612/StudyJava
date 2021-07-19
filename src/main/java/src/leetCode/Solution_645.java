package src.leetCode;

import java.util.Arrays;

/**
 * @author hjj199612
 * @date 2021/7/4 12:30 下午
 * @description645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_645 {

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
        Solution_645 solution_645 = new Solution_645();
        int[] a = {37,62,43,27,12,66,36,18,39,54,61,65,47,32,23,2,46,8,4,24,29,38,63,39,25,11,45,28,44,52,15,30,21,7,57,49,1,59,58,14,9,40,3,42,56,31,20,41,22,50,13,33,6,10,16,64,53,51,19,17,48,26,34,60,35,5};
        System.out.println(Arrays.toString(solution_645.findErrorNums(a)));

    }

    public int[] findErrorNums(int[] nums) {

        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int ind = nums[i] - 1;
            int temp = nums[i];
            nums[i] = nums[ind];
            nums[ind] = temp;
        }
        for (int i = 0; i < nums.length; i++) {
            int ind = nums[i] - 1;
            int temp = nums[i];
            nums[i] = nums[ind];
            nums[ind] = temp;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                arr[0] = nums[i];
                arr[1] = i + 1;
            }
        }
        return arr;


//        int[] arr = new int[2];
//        int[] tong = new int[nums.length];
//        for (int num : nums) {
//            tong[num - 1]++;
//        }
//        for (int i = 0; i < tong.length; i++) {
//            if (tong[i] == 0) arr[1] = i + 1;
//            if (tong[i] == 2) arr[0] = i + 1;
//        }
//        return arr;
    }
}
