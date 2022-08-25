package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hjj
 * @date 2022/8/18 11:51
 * @description ��ָ Offer II 043. ����ȫ��������ӽڵ�
 * ��ȫ��������ÿһ�㣨�����һ���⣩������ȫ��䣨�����ڵ����ﵽ��󣬵� n ���� 2n-1?���ڵ㣩�ģ��������еĽڵ㶼�����ܵؼ�������ࡣ
 * <p>
 * ���һ������ȫ��������ʼ�������ݽṹ?CBTInserter����֧�����¼��ֲ�����
 * <p>
 * CBTInserter(TreeNode root)?ʹ�ø��ڵ�Ϊ?root?�ĸ�������ʼ�������ݽṹ��
 * CBTInserter.insert(int v)? �����в���һ���½ڵ㣬�ڵ�����Ϊ TreeNode��ֵΪ v ��ʹ��������ȫ��������״̬�������ز�����½ڵ�ĸ��ڵ��ֵ��
 * CBTInserter.get_root() ���������ĸ��ڵ㡣
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/NaqhDT
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_Offer_II_043 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        CBTInserter cbtInserter = new CBTInserter(treeNode1);
        System.out.println(cbtInserter.insert(7));
        System.out.println(cbtInserter.insert(8));
        System.out.println(cbtInserter.get_root());
    }

    static class CBTInserter {

        private TreeNode root;

        private List<TreeNode> list;

        public CBTInserter(TreeNode root) {
            this.root = root;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<TreeNode> treeNodes = new ArrayList<>();
                while (!queue.isEmpty()) treeNodes.add(queue.poll());
                boolean flag = false;
                for (TreeNode treeNode : treeNodes) {
                    if (treeNode.left == null || treeNode.right == null) flag = true;
                }
                if (flag) {
                    list = treeNodes;
                    return;
                } else {
                    for (TreeNode node : treeNodes) {
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                }
            }
        }

        public int insert(int v) {
            int parent = -1;
            boolean flag = false;
            for (TreeNode node : list) {
                if (node.left == null) {
                    node.left = new TreeNode(v);
                    parent = node.val;
                    break;
                } else if (node.right == null) {
                    node.right = new TreeNode(v);
                    parent = node.val;
                    break;
                }
            }
            for (TreeNode node : list) {
                if (node.left == null || node.right == null) flag = true;
            }
            if (!flag) {
                List<TreeNode> newList = new ArrayList<>(list.size() * 2);
                for (TreeNode node : list) {
                    newList.add(node.left);
                    newList.add(node.right);
                }
                list = newList;
            }
            return parent;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
