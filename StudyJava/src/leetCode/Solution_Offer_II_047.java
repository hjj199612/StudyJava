package leetCode;

/**
 * @author hjj
 * @date 2022/8/18 11:51
 * @description 剑指 Offer II 047. 二叉树剪枝
 * 给定一个二叉树 根节点?root?，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 * <p>
 * 节点 node 的子树为?node 本身，以及所有 node?的后代。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pOCWxh
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_Offer_II_047 {

    public static void main(String[] args) {

    }

    public TreeNode pruneTree(TreeNode root) {
        if (root.left != null) root.left = pruneTree(root.left);
        if (root.right != null) root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}
