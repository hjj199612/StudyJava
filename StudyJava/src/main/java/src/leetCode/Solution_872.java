package src.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjj24
 * @date 2021-5-10 14:34
 * 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 **/
public class Solution_872 {

    public static void main(String[] args) {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = per(root1, new ArrayList<>());
        List<Integer> list2 = per(root2, new ArrayList<>());
        if (list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }

    public List<Integer> per(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        if (root.left != null) per(root.left, list);
        if (root.right != null) per(root.right, list);
        return list;
    }

}
