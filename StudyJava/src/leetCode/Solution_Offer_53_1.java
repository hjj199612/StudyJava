package leetCode;

/**
 * @author huangjj24
 * @date 2021-7-16 8:49
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 **/
public class Solution_Offer_53_1 {

    public static void main(String[] args) {
        Solution_Offer_53_1 solution_offer_53_1 = new Solution_Offer_53_1();
        int[] arr = {1};
        System.out.println(solution_offer_53_1.search(arr, 1));
    }

    public int search(int[] nums, int target) {
        int count = 0, l = 0, r = nums.length - 1, ind = -1;
        while (l <= r) {
            int mid = r + (l - r) / 2;
            if (nums[mid] == target) {
                ind = mid;
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (ind == -1)
            return 0;
        else {
            l = ind - 1;
            r = ind + 1;
            count++;
            while (l >= 0 && nums[l--] == target) {
                count++;
            }
            while (r < nums.length && nums[r++] == target) {
                count++;
            }
        }
        return count;
    }
}
