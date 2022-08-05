package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1403 {

    public static void main(String[] args) {

    }


    public List<Integer> minSubsequence(int[] nums) {
        int sumAll = 0, sum = 0;
        for (int num : nums) sumAll += num;
        sumAll /= 2;
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (sum > sumAll) return res;
            sum += nums[i];
            res.add(nums[i]);
        }
        return res;
    }
}
 