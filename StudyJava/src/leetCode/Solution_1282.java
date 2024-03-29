package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hjj199612
 * @date 2022/8/12 11:14 上午
 * @description 1282. 用户分组
 * 有?n?个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID?。
 * <p>
 * 给定一个整数数组 groupSizes ，其中?groupSizes[i]?是第 i 个人所在的组的大小。例如，如果?groupSizes[1] = 3?，则第 1 个人必须位于大小为 3 的组中。
 * <p>
 * 返回一个组列表，使每个人 i 都在一个大小为?groupSizes[i]?的组中。
 * <p>
 * 每个人应该?恰好只?出现在?一个组?中，并且每个人必须在一个组中。如果有多个答案，返回其中?任何?一个。可以?保证?给定输入?至少有一个?有效的解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1282 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) map.put(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        map.forEach((k, v) -> {
            List<Integer> resDtl = new ArrayList<>();
            for (int i = 0; i < v.size(); i++) {
                resDtl.add(v.get(i));
                if (resDtl.size() == k) {
                    res.add(resDtl);
                    resDtl = new ArrayList<>();
                }
            }
        });
        return res;
    }
}
