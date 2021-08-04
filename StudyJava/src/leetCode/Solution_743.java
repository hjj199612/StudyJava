package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author huangjj24
 * @date 2021-8-2 8:52
 * 743. 网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 * <p>
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/network-delay-time
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_743 {

    public static void main(String[] args) {

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] table = new int[n][n];
        for (int[] ints : table) {
            Arrays.fill(ints, INF);
        }
        for (int[] time : times) {
            table[time[0] - 1][time[1] - 1] = time[2];
        }
        int[] res = new int[n];
        Arrays.fill(res,INF);
        res[k - 1] = 0;
        boolean[] flags = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!flags[y] && (x == -1 || res[y] < res[x])) {
                    x = y;
                }
            }
            flags[x] = true;
            for (int y = 0; y < n; ++y) {
                res[y] = Math.min(res[y], res[x] + table[x][y]);
            }
        }
        int ans = Arrays.stream(res).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}
