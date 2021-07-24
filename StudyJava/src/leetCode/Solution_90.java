package leetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huangjj24
 * @date 2021-6-29 11:15
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_90 {

    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(1);
        ls.add(1);
        ls.remove(Integer.valueOf(1));
        System.out.println(ls);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        backTrack(res, ls, nums, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> ls, int[] nums, int start) {
        if (!contain(res, ls)) {
            res.add(new ArrayList<>(ls));
        }
        for (int i = start; i < nums.length; i++) {
            ls.add(nums[i]);
            backTrack(res, ls, nums, i + 1);
            ls.remove(Integer.valueOf(nums[i]));
        }
    }

    private boolean contain(List<List<Integer>> res, List<Integer> ls) {
        Map<Integer, Long> collect = ls.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        for (List<Integer> re : res) {
            Map<Integer, Long> reMap = re.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            if (collect.equals(reMap))
                return true;
        }
        return false;
    }
}
