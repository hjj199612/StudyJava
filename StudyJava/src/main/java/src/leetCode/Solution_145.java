package src.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/
 * @Author: huangjj24
 * @CreateDate: 2021-4-25 10:34
 **/
public class Solution_145 {

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {//递归
        if (root == null) return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {//不递归
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) {
                list.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
}
