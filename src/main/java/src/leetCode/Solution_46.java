package src.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author huangjj24
 * @date 2021-6-18 10:26
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 **/
public class Solution_46 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        backtrack(list, res, 0);
        return res;
    }

    public void backtrack(List<Integer> output, List<List<Integer>> res, int start) {
        if (start == output.size()) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = start; i < output.size(); i++) {
            Collections.swap(output, i, start);
            backtrack(output, res, start + 1);
            Collections.swap(output, i, start);
        }
    }
}
