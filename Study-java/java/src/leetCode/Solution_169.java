package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-7-9 17:42
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_169 {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int res = nums[0], count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res)
                count++;
            else {
                if (count == 0)
                    res = nums[i];
                else
                    count--;
            }
        }
        return res;
    }
}
