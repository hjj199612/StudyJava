package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjj24
 * @date 2021-6-22 10:50
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 **/
public class Solution_77 {

    public static void main(String[] args) {
        Solution_77 solution_77 = new Solution_77();
        solution_77.combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(k);
        dfs(res, 1, k , list,n);
        return res;
    }

    private void dfs(List<List<Integer>> res, int start, int k, List<Integer> list, int n) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(res, i + 1, k, list, n);
            list.remove(Integer.valueOf(i));
        }
    }
}
