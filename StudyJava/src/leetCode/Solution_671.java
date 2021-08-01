package leetCode;

/**
 * @author huangjj24
 * @date 2021-7-27 10:35
 * 671. 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_671 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        Solution_671 solution_671 = new Solution_671();
        System.out.println(solution_671.findSecondMinimumValue(treeNode1));
    }

    int min, secondMin;

    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        secondMin = min;
        return dg(root) == min ? -1 : secondMin;
    }

    public int dg(TreeNode root) {
        if (root == null)
            return secondMin;
        if (root.val != min) {
            if (secondMin == min) {
                secondMin = root.val;
            } else {
                secondMin = Math.min(secondMin, root.val);
            }
            return secondMin;
        } else {
            int x = dg(root.left), y = dg(root.right);
            if (x == min)
                return y;
            if (y == min)
                return x;
            return Math.min(x, y);
        }
    }
}
