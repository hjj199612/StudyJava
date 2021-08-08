package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author huangjj24
 * @date 2021-8-5 8:56
 * 802. 找到最终的安全状态
 * <p>
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 * <p>
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 * <p>
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 * <p>
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 **/
public class Solution_802 {

    public static void main(String[] args) {
        int[][] arr = {{}, {0, 2, 3, 4}, {3}, {4}, {}};
        Solution_802 solution_802 = new Solution_802();
        System.out.println(solution_802.eventualSafeNodes(arr));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> res = new TreeSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                res.add(i);
            }
        }
        for (int j = 0; j < graph.length; j++) {
            int size = res.size();
            for (int i = 0; i < graph.length; i++) {
                if (graph[i].length > 0) {
                    boolean flag = true;
                    for (int next : graph[i]) {
                        if (!res.contains(next)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        res.add(i);
                        graph[i] = new int[0];
                    }
                }
            }
            if (size == res.size()) {
                break;//不加判断超时
            }
        }
        return new ArrayList<>(res);
    }
}
