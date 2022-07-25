package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 * <p>
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 * <p>
 * 实现 CBTInserter 类:
 * <p>
 * CBTInserter(TreeNode root)?使用头节点为?root?的给定树初始化该数据结构；
 * CBTInserter.insert(int v)? 向树中插入一个值为?Node.val == val的新节点?TreeNode。使树保持完全二叉树的状态，并返回插入节点?TreeNode?的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/complete-binary-tree-inserter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_919 {

    public static void main(String[] args) {

    }

    class CBTInserter {

        private TreeNode root;
        LinkedList<TreeNode> queue = new LinkedList<>();

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue.add(root);
        }

        public int insert(int val) {
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left == null) {
                    poll.left = new TreeNode(val);
                    queue.addFirst(poll);
                    return poll.val;
                } else if (poll.right == null) {
                    poll.right = new TreeNode(val);
                    queue.add(poll.left);
                    queue.add(poll.right);
                    return poll.val;
                } else {
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
            }
            return -1;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
