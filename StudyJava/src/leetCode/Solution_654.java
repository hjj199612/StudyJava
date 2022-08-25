package leetCode;

/**
 * @author hjj
 * @date 2022/8/20 8:59
 * @description 654. ��������
 * ����һ�����ظ�����������?nums ��?��������?������������㷨��?nums �ݹ�ع���:
 * <p>
 * ����һ�����ڵ㣬��ֵΪ?nums �е����ֵ��
 * �ݹ�������ֵ?���?��?������ǰ׺��?������������
 * �ݹ�������ֵ �ұ� ��?�������׺��?������������
 * ����?nums ������ �������� ��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/maximum-binary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_654 {

    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);
        int maxIndex = start, i = start;
        while (++i <= end) {
            if (nums[maxIndex] < nums[i]) maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        return root;
    }
}
