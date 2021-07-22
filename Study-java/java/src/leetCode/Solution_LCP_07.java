package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-7-1 8:45
 * LCP 07. 传递信息
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * <p>
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_LCP_07 {

    public static void main(String[] args) {
        int[][] a = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        Solution_LCP_07 solution_lcp_07 = new Solution_LCP_07();
        System.out.println(solution_lcp_07.numWays(5, a, 3));
    }

    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] ints : relation) {
                dp[i][ints[1]] += dp[i - 1][ints[0]];
            }
        }
        return dp[k][n - 1];


        // Map<Integer, Set<Integer>> map = new HashMap<>();
        // for (int[] ints : relation) {
        //     Set<Integer> set = map.getOrDefault(ints[0], new HashSet<>());
        //     set.add(ints[1]);
        //     map.put(ints[0], set);
        // }
        // Queue<Integer> queue = new LinkedList<>();
        // queue.add(0);
        // int size = 1, count = 0;
        // while (!queue.isEmpty() && k > 0) {
        //     Integer x = queue.poll();
        //     Set<Integer> set = map.getOrDefault(x, new HashSet<>());
        //     if (set.contains(n - 1) && k == 1) {
        //         count++;
        //     }
        //     queue.addAll(set);
        //     size--;
        //     if (size == 0) {
        //         k--;
        //         size = queue.size();
        //     }
        // }
        // return count;
    }
}
