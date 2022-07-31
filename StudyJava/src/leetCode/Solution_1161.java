package leetCode;

import java.util.LinkedList;

/**
 * 1161. 最大层内元素和
 * 给你一个二叉树的根节点?root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中?最小 的那个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1161 {

    public static void main(String[] args) {

    }

    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size(), cur = 1, res = 1, max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int sum = 0;
            while (size > 0) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
                size--;
            }
            if (sum > max) {
                max = sum;
                res = cur;
            }
            cur++;
            size = queue.size();
        }
        return res;
    }
}
