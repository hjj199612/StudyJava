package leetCode;

import java.util.LinkedList;

/**
 * 623. �ڶ�����������һ��
 * ����һ���������ĸ�?root?���������� val ��?depth?���ڸ��������?depth?�����һ��ֵΪ val �Ľڵ��С�
 * <p>
 * ע�⣬���ڵ�?root?λ�����?1?��
 * <p>
 * �ӷ���������:
 * <p>
 * ��������?depth���������Ϊ?depth - 1 ��ÿ���ǿ����ڵ� cur ����������ֵΪ val �����ڵ���Ϊ cur ����������������������
 * cur ԭ����������Ӧ�����µ�������������������
 * cur ԭ����������Ӧ�����µ�������������������
 * ��� depth == 1 ��ζ��?depth - 1?����û����ȣ���ô����һ�����ڵ㣬ֵ val ��Ϊ����ԭʼ�����¸�����ԭʼ�������¸�����������
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/add-one-row-to-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_623 {

    public static void main(String[] args) {

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) return new TreeNode(val, root, null);
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (--depth == 1) {
                while (!queue.isEmpty()) {
                    TreeNode poll = queue.poll();
                    poll.left = new TreeNode(val, poll.left, null);
                    poll.right = new TreeNode(val, null, poll.right);
                }
                return root;
            } else {
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode poll = queue.poll();
                    if (poll.left != null) queue.add(poll.left);
                    if (poll.right != null) queue.add(poll.right);
                }
            }
        }
        return root;
    }
}
