package src.leetCode;

import java.util.Arrays;

/**
 * @author huangjj24
 * @date 2021-7-14 8:58
 * 1818. 绝对差值和
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-sum-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1818 {

    public static void main(String[] args) {
        Solution_1818 solution_1818 = new Solution_1818();
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        // System.out.println(solution_1818.binarySearch(arr, 1));
        int[] arr1 = {1, 10, 4, 4, 2, 7};
        int[] arr2 = {9, 3, 5, 1, 7, 4};
        System.out.println(solution_1818.minAbsoluteSumDiff(arr1, arr2));
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int redMax = 0, sum = 0, n = nums1.length;
        int[] arr = nums1.clone();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums1[i] - nums2[i]);
            int y = binarySearch(arr, nums2[i]);
            sum = sum % 1000000007 + x;
            redMax = Math.max(x - y, redMax);
        }
        return (sum + 1000000007 - redMax) % 1000000007;
    }

    public int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        if (target >= arr[r]) {
            return target - arr[r];
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target)
                return 0;
            else if (arr[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
            if (l + 1 == r) {
                return Math.min(Math.abs(target - arr[l]), Math.abs(target - arr[r]));
            }
        }
        return Math.abs(target - arr[l]);
    }
}
