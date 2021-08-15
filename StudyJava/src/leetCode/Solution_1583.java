package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author hjj199612
 * @date 2021/8/14 5:04 下午
 * @description 1583. 统计不开心的朋友
 * 给你一份 n 位朋友的亲近程度列表，其中 n 总是 偶数 。
 * <p>
 * 对每位朋友 i，preferences[i] 包含一份 按亲近程度从高到低排列 的朋友列表。换句话说，排在列表前面的朋友与 i 的亲近程度比排在列表后面的朋友更高。每个列表中的朋友均以 0 到 n-1 之间的整数表示。
 * <p>
 * 所有的朋友被分成几对，配对情况以列表 pairs 给出，其中 pairs[i] = [xi, yi] 表示 xi 与 yi 配对，且 yi 与 xi 配对。
 * <p>
 * 但是，这样的配对情况可能会是其中部分朋友感到不开心。在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：
 * <p>
 * x 与 u 的亲近程度胜过 x 与 y，且
 * u 与 x 的亲近程度胜过 u 与 v
 * 返回 不开心的朋友的数目 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-unhappy-friends
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1583 {

    public static void main(String[] args) {
        Solution_1583 solution_1583 = new Solution_1583();
//        {{1,3,2},{2,3,0},{1,3,0},{0,2,1}}
//        {{1,3},{0,2}}
        int[][] preferences = {{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}};
        int[][] pairs = {{1, 3}, {0, 2}};
        System.out.println(solution_1583.unhappyFriends(4, preferences, pairs));
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        HashSet<Integer> set = new HashSet<>();
        int notHappy = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        while (set.size() > 0) {
            Integer x = set.iterator().next();
            Integer y = map.get(x);
            boolean unhappy = false;
            int[] arr = preferences[x];
            for (int i = 0; ; i++) {
                int u = arr[i];
                if (u == y) {
                    break;
                }
                int[] uArr = preferences[u];
                int v = map.get(u);
                for (int j = 0; ; j++) {
                    if (uArr[j] == v) {
                        break;
                    }
                    if (uArr[j] == x) {
                        unhappy = true;
                        notHappy++;
                        break;
                    }
                }
                if (unhappy) break;
            }
            set.remove(x);
        }
        return notHappy;
    }
}
