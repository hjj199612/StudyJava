package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 */
public class Solution_1302 {

    public static void main(String[] args) {

    }

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            int size = queue.size();
            int res = 0;
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                res += poll.val;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            if (queue.isEmpty()) return res;
        }
    }
}
