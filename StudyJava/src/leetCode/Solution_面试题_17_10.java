package leetCode;

/**
 * @author huangjj24
 * @date 2021-7-9 8:58
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_面试题_17_10 {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int res = nums[0], count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res)
                count++;
            else {
                if (count == 0) {
                    res = nums[i];
                } else
                    count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == res)
                count++;
        }
        if (count > nums.length / 2)
            return res;
        return -1;
    }
}