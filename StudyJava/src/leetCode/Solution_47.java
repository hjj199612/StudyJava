package leetCode;

import java.util.*;

/**
 * @author huangjj24
 * @date 2021-6-22 11:32
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 **/
public class Solution_47 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        backTrack(res, list, 0);
        return new ArrayList<>(res);
    }

    private void backTrack(Set<List<Integer>> res, List<Integer> list, int start) {
        if (start == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, start, i);
            backTrack(res, list, start + 1);
            Collections.swap(list, start, i);
        }
    }
}
