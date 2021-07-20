package src.leetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangjj24
 * @date 2021-5-11 14:28
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 **/
public class Solution_Offer_32_I {

    public static void main(String[] args) {

    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        List<Integer> list = levelOrder(treeNodes, new ArrayList<>());
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = list.get(i);
        return arr;
    }

    private List<Integer> levelOrder(Deque<TreeNode> treeNodes, List<Integer> list) {
        if (treeNodes.isEmpty()) return list;
        int size = treeNodes.size();
        while (size-- > 0) {
            TreeNode treeNode = treeNodes.pop();
            if (treeNode.left != null) treeNodes.add(treeNode.left);
            if (treeNode.right != null) treeNodes.add(treeNode.right);
            list.add(treeNode.val);
        }
        levelOrder(treeNodes, list);
        return list;
    }

    public int[] levelOrder2(TreeNode root) { //不递归
        if (root == null) return new int[0];
        Deque<TreeNode> treeNodes = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.pop();
            if (treeNode.left != null) treeNodes.add(treeNode.left);
            if (treeNode.right != null) treeNodes.add(treeNode.right);
            list.add(treeNode.val);
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = list.get(i);
        return arr;
    }
}
