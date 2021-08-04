package leetCode;

import java.util.Arrays;

/**
 * @author huangjj24
 * @date 2021-8-4 8:50
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 **/
public class Solution_611 {

    public static void main(String[] args) {
        Solution_611 s = new Solution_611();
        int[] arr = {2, 2, 3, 4};
        System.out.println(s.triangleNumber(arr));
    }

    public int triangleNumber(int[] nums) {
        int res = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                continue;
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] <= nums[k]) {
                        break;
                    } else {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
