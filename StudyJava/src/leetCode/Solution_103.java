package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author huangjj24
 * @date 2021-6-22 13:38
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 **/
public class Solution_103 {

    public static void main(String[] args) {
        Solution_103 solution_103 = new Solution_103();
        TreeNode r3 = new TreeNode(3);
        TreeNode r9 = new TreeNode(9);
        TreeNode r20 = new TreeNode(20);
        TreeNode r15 = new TreeNode(15);
        TreeNode r7 = new TreeNode(7);
        r3.left = r9;
        r3.right = r20;
        r20.left = r15;
        r20.right = r7;
        solution_103.zigzagLevelOrder(r3);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> ls = new ArrayList<>(size);
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                ls.add(queue.poll());
            }
            if ((res.size() & 1) == 0) {
                for (int i = 0; i < ls.size(); i++) {
                    list.add(ls.get(i).val);
                }
            } else {
                for (int i = ls.size() - 1; i >= 0; i--) {
                    list.add(ls.get(i).val);
                }
            }
            res.add(list);
            for (TreeNode node : ls) {
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return res;
    }
}
