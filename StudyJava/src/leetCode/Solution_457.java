package leetCode;

/**
 * @author hjj199612
 * @date 2021/8/7 8:24 下午
 * @description 457. 环形数组是否存在循环
 * 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 * <p>
 * 如果 nums[i] 是正数，向前 移动 nums[i] 步
 * 如果 nums[i] 是负数，向后 移动 nums[i] 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 * <p>
 * 数组中的 循环 由长度为 k 的下标序列 seq ：
 * <p>
 * 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/circular-array-loop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_457 {

    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4, -5};
        Solution_457 solution_457 = new Solution_457();
        System.out.println(solution_457.circularArrayLoop(arr));
    }

    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int slow = i, fast = next(nums, i);
            while (nums[i] * nums[fast] > 0 && nums[next(nums, fast)] * nums[i] > 0) {
                if (slow == fast) {
                    if (slow == next(nums, slow)) {
                        break;
                    } else {
                        return true;
                    }
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
        }
        return false;
    }

    private int next(int[] nums, int i) {
        int n = nums.length;
        return (i + nums[i] % n + n) % n;
    }
}
