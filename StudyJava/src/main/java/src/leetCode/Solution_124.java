package src.leetCode;

/**
 * @author hjj199612
 * @date 2021/7/18 2:13 下午
 * @description 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_124 {

    public static void main(String[] args) {

    }

    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recursion(root);
        return sum;
    }

    private int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(recursion(root.left), 0);
        int rightSum = Math.max(recursion(root.right), 0);
        int rootSum = leftSum + rightSum + root.val;
        sum = Math.max(sum, rootSum);
        return root.val+Math.max(leftSum,rightSum);
    }


}
