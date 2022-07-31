package leetCode;

import java.util.LinkedList;

/**
 * 1161. ������Ԫ�غ�
 * ����һ���������ĸ��ڵ�?root������ڵ�λ�ڶ������ĵ� 1 �㣬�����ڵ���ӽڵ�λ�ڵ� 2 �㣬�������ơ�
 * <p>
 * �뷵�ز���Ԫ��֮�� ��� ���Ǽ��㣨����ֻ��һ�㣩�Ĳ�ţ�����������?��С ���Ǹ���
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1161 {

    public static void main(String[] args) {

    }

    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size(), cur = 1, res = 1, max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int sum = 0;
            while (size > 0) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
                size--;
            }
            if (sum > max) {
                max = sum;
                res = cur;
            }
            cur++;
            size = queue.size();
        }
        return res;
    }
}
