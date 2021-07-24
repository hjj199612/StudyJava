package leetCode;

/**
 * @author huangjj24
 * @date 2021-6-3 9:53
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 **/
public class Solution_35 {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, res = nums.length;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                res = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return res;
    }
}
