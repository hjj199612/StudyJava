package leetCode;



/**
 * @author huangjj24
 * @date 2021-5-27 10:16
 * 1721. 交换链表中的节点
 * 给你链表的头节点 head 和一个整数 k 。
 * <p>
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 **/
public class Solution_1721 {

    public static void main(String[] args) {
        int m=2,n=4;
        int[][][] dp = new int[m + 1][n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i][i] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j - k][k - 1] + dp[i - 1][j - k][k];
                    if (j > k) {
                        if (k > 2)
                            dp[i][j][k] += dp[i - 1][j - k][k - 2];
                        if (k >= 3)
                            dp[i][j][k] += dp[i - 1][j - k][k - 3];
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += dp[m][n][i];
        }
        System.out.println(sum);
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode node = head;
        ListNode theK = null;
        ListNode lastK = null;
        while (node != null) {
            if (k == 1) {
                theK = node;
                lastK = head;
            } else if (k < 0) {
                lastK = lastK.next;
            }
            k--;
            node = node.next;
        }
        int temp = lastK.val;
        lastK.val = theK.val;
        theK.val = temp;
        return head;
    }
}
