package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-5-12 10:45
 * 剑指 Offer 55 - II. 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 **/
public class Solution_Offer_55_II {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) { return root == null ? true : (Math.abs(getHigh(root.left) - getHigh(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)); }
    public int getHigh(TreeNode root) { return root == null ? 0 : 1 + Math.max(getHigh(root.left), getHigh(root.right)); }

}
