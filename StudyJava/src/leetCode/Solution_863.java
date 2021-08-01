package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author huangjj24
 * @date 2021-7-28 8:58
 * 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_863 {

    public static void main(String[] args) {

    }

    TreeNode root = null;
    List<Integer> res = new LinkedList<>();
    Set<TreeNode> set = new LinkedHashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.root = root;
        distanceK(target, k);
        return res;
    }

    public void distanceK(TreeNode target, int k) {
        if (target == null)
            return;
        if (k == 0) {
            res.add(target.val);
            return;
        }
        TreeNode father = getFather(root, target);
        set.add(target);
        if (!set.contains(father)) {
            set.add(father);
            distanceK(father, k - 1);
        }
        if (!set.contains(target.left)) {
            set.add(target.left);
            distanceK(target.left, k - 1);
        }
        if (!set.contains(target.right)) {
            set.add(target.right);
            distanceK(target.right, k - 1);
        }
    }

    public TreeNode getFather(TreeNode node, TreeNode targetNode) {
        if (node == null)
            return null;
        if (node.left == targetNode || node.right == targetNode) {
            return node;
        }
        TreeNode father = getFather(node.left, targetNode);
        if (father != null)
            return father;
        father = getFather(node.right, targetNode);
        return father;
    }
}
