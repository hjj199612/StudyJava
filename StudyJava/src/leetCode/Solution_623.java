package leetCode;

import java.util.LinkedList;

/**
 * 623. 在二叉树中增加一行
 * 给定一个二叉树的根?root?和两个整数 val 和?depth?，在给定的深度?depth?处添加一个值为 val 的节点行。
 * <p>
 * 注意，根节点?root?位于深度?1?。
 * <p>
 * 加法规则如下:
 * <p>
 * 给定整数?depth，对于深度为?depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着?depth - 1?根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-one-row-to-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_623 {

    public static void main(String[] args) {

    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) return new TreeNode(val, root, null);
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (--depth == 1) {
                while (!queue.isEmpty()) {
                    TreeNode poll = queue.poll();
                    poll.left = new TreeNode(val, poll.left, null);
                    poll.right = new TreeNode(val, null, poll.right);
                }
                return root;
            } else {
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode poll = queue.poll();
                    if (poll.left != null) queue.add(poll.left);
                    if (poll.right != null) queue.add(poll.right);
                }
            }
        }
        return root;
    }
}
