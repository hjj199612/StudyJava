package leetCode;

/**
 * @author hjj
 * @date 2022/8/18 11:51
 * @description ��ָ Offer II 047. ��������֦
 * ����һ�������� ���ڵ�?root?������ÿ���ڵ��ֵҪô�� 0��Ҫô�� 1��������ö����������нڵ��ֵΪ 0 ��������
 * <p>
 * �ڵ� node ������Ϊ?node �����Լ����� node?�ĺ����
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/pOCWxh
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_Offer_II_047 {

    public static void main(String[] args) {

    }

    public TreeNode pruneTree(TreeNode root) {
        if (root.left != null) root.left = pruneTree(root.left);
        if (root.right != null) root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }
}
