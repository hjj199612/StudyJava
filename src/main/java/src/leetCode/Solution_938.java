package src.leetCode;

/**
 * @Description:938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * @Author: huangjj24
 * @CreateDate: 2021-4-27 9:20
 **/
public class Solution_938 {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {

    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)return 0;
        int sum=0;
        if(root.val>=low&&root.val<=high) {
            sum+=root.val;
            sum+= rangeSumBST(root.right,low,high);
            sum+= rangeSumBST(root.left,low,high);
        }
        if(root.val<low) sum+= rangeSumBST(root.right,low,high);
        if(root.val>high) sum+= rangeSumBST(root.left,low,high);
        return sum;
    }

}
