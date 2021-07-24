package leetCode;

/**
 * @author huangjj24
 * @date 2021-6-4 11:10
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_34 {

    public static void main(String[] args) {
        int[] a = {1,1,2};
        System.out.println(searchRange(a, 1));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int l = 0, r = nums.length-1, temp = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                temp = mid;
                break;
            }
            if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        res[0] = temp;
        res[1] = temp;
        if (temp == -1) {
            return res;
        }
        while (res[0] > 0 && nums[res[0] - 1] == target) res[0]--;
        while (res[1] < nums.length - 1 && nums[res[1] + 1] == target) res[1]++;
        return res;
    }
}
