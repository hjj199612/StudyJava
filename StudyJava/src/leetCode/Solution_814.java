package leetCode;

/**
 * 814. 二叉树剪枝
 * 给你二叉树的根结点?root?，此外树的每个结点的值要么是 0 ，要么是 1 。
 * <p>
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * <p>
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-pruning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution_814 {

    public static void main(String[] args) {

    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }

//    public TreeNode pruneTree(TreeNode root) {
//        TreeNode treeNode = removeAll0(root);
//        if (treeNode.left == null && treeNode.right == null && treeNode.val == 0)
//            return null;
//        else return treeNode;
//    }

    public TreeNode removeAll0(TreeNode root) {
        if (root == null) return root;
        removeChild(root);
        removeAll0(root.left);
        removeAll0(root.right);
        removeChild(root);
        return root;
    }

    public TreeNode removeChild(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null && left.left == null && left.right == null && left.val == 0) root.left = null;
        if (right != null && right.left == null && right.right == null && right.val == 0) root.right = null;
        return root;
    }


}
