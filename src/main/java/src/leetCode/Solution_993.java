package src.leetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huangjj24
 * @date 2021-5-17 14:54
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * <p>
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * <p>
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * <p>
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_993 {

    public static void main(String[] args) {

    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode fx = getFather(root,x);
        TreeNode fy = getFather(root,y);
        return fx!=fy&&getHigh(root,fx)==getHigh(root,fy);
    }

    public TreeNode getFather(TreeNode root, int x) {
        if(root==null) return null;
        if ((root.left != null && root.left.val == x)||(root.right != null && root.right.val == x)) return root;
        TreeNode node = getFather(root.left,x);
        return node!=null?node:getFather(root.right,x);
    }

    public int getHigh(TreeNode root, TreeNode x) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int h = 1;
        int size=1;
        while (!deque.isEmpty()){
            if(size==0){
                h++;
                size=deque.size();
            }
            TreeNode node = deque.pop();
            if(node==x) return h;
            if(node.left!=null) deque.add(node.left);
            if(node.right!=null) deque.add(node.right);
            size--;
        }
        return 0;
    }
}
