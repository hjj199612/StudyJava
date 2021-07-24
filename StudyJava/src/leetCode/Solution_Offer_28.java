package leetCode;

/**
 * @author huangjj24
 * @date 2021-5-11 14:28
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 **/
public class Solution_Offer_28 {


    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }


//    public boolean isSymmetric(TreeNode root) {
//        if(root==null) return true;
//        List<Integer> leftList = isSymmetricLeft(root.left, new ArrayList<>());
//        List<Integer> rightList = isSymmetricRight(root.right, new ArrayList<>());
//        if (leftList.size() != rightList.size()) return false;
//        for (int i = 0; i < leftList.size(); i++) {
//            if (leftList.get(i) != rightList.get(i)) return false;
//        }
//        return true;
//    }
//
//    public List<Integer> isSymmetricLeft(TreeNode root, List<Integer> leftList) {
//        if (root == null) return leftList;
//        leftList.add(root.val);
//        if (root.left != null) isSymmetricLeft(root.left, leftList);
//        else leftList.add(null);
//        if (root.right != null) isSymmetricLeft(root.right, leftList);
//        else leftList.add(null);
//        return leftList;
//    }
//
//    public List<Integer> isSymmetricRight(TreeNode root, List<Integer> rightList) {
//        if (root == null) return rightList;
//        rightList.add(root.val);
//        if (root.right != null) isSymmetricRight(root.right, rightList);
//        else rightList.add(null);
//        if (root.left != null) isSymmetricRight(root.left, rightList);
//        else rightList.add(null);
//        return rightList;
//    }
}
