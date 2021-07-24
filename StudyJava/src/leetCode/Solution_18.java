package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-5-1 11:37
 **/
public class Solution_18 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int l = nums.length;
        for (int i = 0; i < l; ) {
            for (int j = i + 1; j < l; ) {
                int x = j + 1, y = l - 1;
                while (x < y) {
                    int sum = nums[i] + nums[j] + nums[x] + nums[y];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>(4);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[x]);
                        list.add(nums[y]);
                        lists.add(list);
                        x++;
                        y--;
                        while (x < y  && nums[x] == nums[x - 1]) x++;
                        while (x < y  && nums[y] == nums[y + 1]) y--;
                    } else if (sum < target) {
                        x++;
                        while (x < y  && nums[x] == nums[x - 1]) x++;
                    } else {
                        y--;
                        while (x < y  && nums[y] == nums[y + 1]) y--;
                    }
                }
                j++;
                while (j  < l && nums[j] == nums[j - 1]) j++;
            }
            i++;
            while (i<l && nums[i] == nums[i - 1]) i++;
        }
        return lists;
    }
}
