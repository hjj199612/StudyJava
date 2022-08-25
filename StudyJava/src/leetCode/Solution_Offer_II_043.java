package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hjj
 * @date 2022/8/18 11:51
 * @description 剑指 Offer II 043. 往完全二叉树添加节点
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1?个节点）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一个用完全二叉树初始化的数据结构?CBTInserter，它支持以下几种操作：
 * <p>
 * CBTInserter(TreeNode root)?使用根节点为?root?的给定树初始化该数据结构；
 * CBTInserter.insert(int v)? 向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的根节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/NaqhDT
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
