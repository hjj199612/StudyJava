package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-6-21 14:46
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_88 {

    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int l = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i == -1)
                nums1[l--] = nums2[j--];
            else if (j == -1)
                nums1[l--] = nums1[i--];
            else if (nums1[i] > nums2[j])
                nums1[l--] = nums1[i--];
            else
                nums1[l--] = nums2[j--];
        }
    }
}
