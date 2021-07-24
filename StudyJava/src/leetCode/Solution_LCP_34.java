package leetCode;

/**
 * @author huangjj24
 * @date 2021-5-12 10:19
 * LCP 34. 二叉树染色
 * 小扣有一个根结点为 root 的二叉树模型，初始所有结点均为白色，可以用蓝色染料给模型结点染色，模型的每个结点有一个 val 价值。小扣出于美观考虑，希望最后二叉树上每个蓝色相连部分的结点个数不能超过 k 个，求所有染成蓝色的结点价值总和最大是多少？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-ran-se-UGC
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_LCP_34 {

    public static void main(String[] args) {

    }

    public int maxValue(TreeNode root, int k) {
        int[] dp = dynamic(root, k);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            //取root的各种染色情况的最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private int[] dynamic(TreeNode root, int k) {
        int[] dp = new int[k + 1];
        //1.初始化：空节点为底，自底向上
        if (root == null) return dp;
        //2.获取左、右子树染色状态的dp表
        //- 左子树
        int[] l = dynamic(root.left, k);
        //- 右子树
        int[] r = dynamic(root.right, k);
        //3.更新处理root 染色/不染色 的情况下的dp表
        //- 不染root
        int ml = Integer.MIN_VALUE, mr = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            //- 分别取子节点的最大值
            ml = Math.max(ml, l[i]);
            mr = Math.max(mr, r[i]);
        }
        dp[0] = ml + mr;
        //- 染root
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < i; j++) {
                //- 还需要染色 i - 1 个点，左子树 j 个，右子树 i-1-j 个
                dp[i] = Math.max(dp[i], root.val + l[j] + r[i - 1 - j]);
            }
        }
        //4.更新完毕，返回后继续向上动态规划
        return dp;
    }

}
