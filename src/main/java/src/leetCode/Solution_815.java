package src.leetCode;

import java.util.*;

/**
 * @author huangjj24
 * @date 2021-6-28 10:13
 * 815. 公交路线
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * <p>
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * <p>
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bus-routes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_815 {

    public static void main(String[] args) {
        Solution_815 solution_815 = new Solution_815();
        int[][] a = {{1, 9, 12, 20, 23, 24, 35, 38}, {10, 21, 24, 31, 32, 34, 37, 38, 43}, {10, 19, 28, 37}, {8}
                , {14, 19}, {11, 17, 23, 31, 41, 43, 44}, {21, 26, 29, 33}, {5, 11, 33, 41}, {4, 5, 8, 9, 24, 44}};
        System.out.println(solution_815.numBusesToDestination(a, 37, 28));
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        int busCount = routes.length, steep = 1;
        Map<Integer, Set<Integer>> siteBusMap = new HashMap<>();
        Map<Integer, Set<Integer>> busSiteMap = new HashMap<>();
        for (int i = 0; i < busCount; i++) {
            Set<Integer> sites = new HashSet<>();
            for (int site : routes[i]) {
                Set<Integer> busSet = siteBusMap.getOrDefault(site, new HashSet<>());
                busSet.add(i);
                siteBusMap.put(site, busSet);
                sites.add(site);
            }
            busSiteMap.put(i, sites);
        }
        Set<Integer> busRe = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(siteBusMap.get(source));
        int size = queue.size();
        while (!queue.isEmpty()) {
            Set<Integer> sites = busSiteMap.get(queue.poll());
            if (sites.contains(target))
                return steep;
            else {
                sites.forEach(e -> {
                    Set<Integer> buses = siteBusMap.get(e);
                    buses.forEach(bus -> {
                        if (!busRe.contains(bus)) {
                            queue.add(bus);
                            busRe.add(bus);
                        }
                    });
                });
            }
            size--;
            if (size == 0) {
                size = queue.size();
                steep++;
            }
        }
        return -1;
    }
}
