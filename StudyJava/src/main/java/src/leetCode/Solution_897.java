package src.leetCode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sun.jmx.remote.internal.ArrayQueue;

/**
 * @Description:897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，
 * 并且每个节点没有左子节点，只有一个右子节点。
 * @Author: huangjj24
 * @CreateDate: 2021-4-25 10:00
 **/
public class Solution_897 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public static TreeNode increasingBST(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        midErgodic(queue, root);
        TreeNode newRoot = queue.poll();
        TreeNode node = newRoot;
        while (!queue.isEmpty()) {
            node.left = null;
            node.right = queue.poll();
            node = node.right;
        }
        node.left = null;
        return newRoot;
    }

    public static void midErgodic(Queue<TreeNode> queue, TreeNode root) {
        if (root == null) return;
        midErgodic(queue, root.left);
        queue.add(root);
        midErgodic(queue, root.right);
    }

}
