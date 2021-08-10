package leetCode;

/**
 * @author hjj199612
 * @date 2021/8/10 9:26 上午
 * @description
 */
public class Solution_413 {

    public static void main(String[] args) {
        Solution_413 solution_413 = new Solution_413();
        int[] arr = {1, 2, 3, 6, 7, 8};
        System.out.println(solution_413.numberOfArithmeticSlices(arr));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int l = 0, r = 1, res = 0, dis = nums[1] - nums[0];
        while (r < nums.length) {
            int newDis = nums[r] - nums[r - 1];
            if (newDis != dis) {
                res += getCount(l, r - 1);
                dis = newDis;
                l = r - 1;
            }
            r++;
        }
        res += getCount(l, r - 1);
        return res;
    }

    private int getCount(int l, int r) {
        if (r - l < 2) return 0;
        int len = r - l + 1, count = 0, arrLen = len;
        while (arrLen >= 3) {
            count += len - arrLen + 1;
            arrLen--;
        }
        return count;
    }
}
