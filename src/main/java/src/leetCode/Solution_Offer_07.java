package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-5-12 10:45
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 ***/
public class Solution_Offer_07 {

    public static void main(String[] args) {
        int[] p = {1,2,3};
        int[] i = {2,3,1};
        System.out.println(buildTree(p, i));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int i = 0;
        while (preorder[0] != inorder[i]) i++;
        return buildTree(preorder, inorder, 0, i, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int head, int mid, int l, int r) {
        TreeNode root = new TreeNode(preorder[head]);
        if (l != mid) {
            int lh = head + 1;
            int lmid = mid;
            for (int i = l; i < mid; i++) {
                if (inorder[i] == preorder[lh]) lmid = i;
            }
            root.left = buildTree(preorder, inorder, head + 1, lmid, l, mid - 1);
        }
            if (r != mid) {
            int rh = r;
            for (int i = head + 1; i < preorder.length; i++) {
                boolean flag = false;
                for (int j = l; j < mid; j++) {
                    if (preorder[i] == inorder[j]) flag = true;
                }
                if (!flag) {
                    rh = i;
                    break;
                }
            }
            int rmid = mid;
            while (inorder[rmid] != preorder[rh]) rmid++;
            root.right = buildTree(preorder, inorder, rh, rmid, mid + 1, r);
        }
        return root;
    }
}
