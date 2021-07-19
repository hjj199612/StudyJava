package src.leetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * @Author: huangjj24
 * @CreateDate: 2021-4-25 10:34
 **/
public class Solution_102 {


    public List<List<Integer>> levelOrder(TreeNode root) { //不递归
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>(size);
            while (size > 0) {
                TreeNode treeNode = deque.pop();
                list.add(treeNode.val);
                if (treeNode.left != null) deque.add(treeNode.left);
                if (treeNode.right != null) deque.add(treeNode.right);
                size--;
            }
            lists.add(list);
        }
        return lists;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) { //递归
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        levelOrder2(list, lists);
        return lists;
    }

    public void levelOrder2(List<TreeNode> treeNodes, List<List<Integer>> lists) { //递归
        List<TreeNode> list = new ArrayList<>();
        List<Integer> dtl = new ArrayList<>();
        treeNodes.forEach(e -> {
            if (e.left != null) list.add(e.left);
            if (e.right != null) list.add(e.right);
            dtl.add(e.val);
        });
        lists.add(dtl);
        if (!list.isEmpty()) levelOrder2(list, lists);
    }
}
