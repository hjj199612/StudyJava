package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 919. ��ȫ������������
 * <p>
 * ��ȫ������ ��ÿһ�㣨�����һ���⣩������ȫ��䣨�����ڵ����ﵽ��󣩵ģ��������еĽڵ㶼�����ܵؼ�������ࡣ
 * <p>
 * ���һ���㷨����һ���½ڵ���뵽һ�������Ķ������У����ڲ���󱣳���������
 * <p>
 * ʵ�� CBTInserter ��:
 * <p>
 * CBTInserter(TreeNode root)?ʹ��ͷ�ڵ�Ϊ?root?�ĸ�������ʼ�������ݽṹ��
 * CBTInserter.insert(int v)? �����в���һ��ֵΪ?Node.val == val���½ڵ�?TreeNode��ʹ��������ȫ��������״̬�������ز���ڵ�?TreeNode?�ĸ��ڵ��ֵ��
 * CBTInserter.get_root() ����������ͷ�ڵ㡣
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/complete-binary-tree-inserter
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_919 {

    public static void main(String[] args) {

    }

    class CBTInserter {

        private TreeNode root;
        LinkedList<TreeNode> queue = new LinkedList<>();

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue.add(root);
        }

        public int insert(int val) {
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left == null) {
                    poll.left = new TreeNode(val);
                    queue.addFirst(poll);
                    return poll.val;
                } else if (poll.right == null) {
                    poll.right = new TreeNode(val);
                    queue.add(poll.left);
                    queue.add(poll.right);
                    return poll.val;
                } else {
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }
            return -1;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
