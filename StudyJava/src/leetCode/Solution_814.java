package leetCode;

/**
 * 814. ��������֦
 * ����������ĸ����?root?����������ÿ������ֵҪô�� 0 ��Ҫô�� 1 ��
 * <p>
 * �����Ƴ������в����� 1 ��������ԭ��������
 * <p>
 * �ڵ� node ������Ϊ node ����������� node �ĺ����
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/binary-tree-pruning
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */

public class Solution_814 {

    public static void main(String[] args) {

    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }

//    public TreeNode pruneTree(TreeNode root) {
//        TreeNode treeNode = removeAll0(root);
//        if (treeNode.left == null && treeNode.right == null && treeNode.val == 0)
//            return null;
//        else return treeNode;
//    }

    public TreeNode removeAll0(TreeNode root) {
        if (root == null) return root;
        removeChild(root);
        removeAll0(root.left);
        removeAll0(root.right);
        removeChild(root);
        return root;
    }

    public TreeNode removeChild(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null && left.left == null && left.right == null && left.val == 0) root.left = null;
        if (right != null && right.left == null && right.right == null && right.val == 0) root.right = null;
        return root;
    }


}
