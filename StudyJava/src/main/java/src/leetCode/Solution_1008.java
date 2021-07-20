package src.leetCode;


/**
 * @Description:1008. 前序遍历构造二叉搜索树
 * <p>
 * 返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 * <p>
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。）
 * <p>
 * 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。
 * @Author: huangjj24
 * @CreateDate: 2021-4-25 10:40
 **/
public class Solution_1008 {

    public static void main(String[] args) {

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = addTreeNode(root, preorder[i]);
        }
        return root;
    }

    public TreeNode addTreeNode(TreeNode root, int num) {
        if (root == null) return new TreeNode(num);
        if (num > root.val) {
            root.right = addTreeNode(root.right, num);
        } else {
            root.left = addTreeNode(root.left, num);
        }
        return root;
    }
}
