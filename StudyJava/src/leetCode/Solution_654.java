package leetCode;

/**
 * @author hjj
 * @date 2022/8/20 8:59
 * @description 654. 最大二叉树
 * 给定一个不重复的整数数组?nums 。?最大二叉树?可以用下面的算法从?nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为?nums 中的最大值。
 * 递归地在最大值?左边?的?子数组前缀上?构建左子树。
 * 递归地在最大值 右边 的?子数组后缀上?构建右子树。
 * 返回?nums 构建的 最大二叉树 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_654 {

    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);
        int maxIndex = start, i = start;
        while (++i <= end) {
            if (nums[maxIndex] < nums[i]) maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        return root;
    }
}
