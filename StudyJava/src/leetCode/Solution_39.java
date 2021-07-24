package leetCode;

import java.util.*;

/**
 * @author huangjj24
 * @date 2021-7-2 11:26
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_39 {

    public static void main(String[] args) {
        Integer i = 0;
        System.out.println((i++));
        System.out.println((++i));
        Integer a = 0;
        Integer b = 1;
        String s = "x";
        swap(a, b, s);
        System.out.println(a);
        System.out.println(b);
        System.out.println(s);
    }

    private static void swap(Integer a, Integer b, String s) {
        s += 1 ;
        Integer x = a;
        a = b;
        b = x;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> ls = new ArrayList<>();
        backTack(res, ls, candidates, 0, target);
        return res;
    }

    private void backTack(List<List<Integer>> res, List<Integer> ls, int[] candidates, int start, int target) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                break;
            }
            ls.add(candidates[i]);
            backTack(res, ls, candidates, i, target - candidates[i]);
            ls.remove(ls.size() - 1);
        }
    }
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     Set<List<Integer>> res = new HashSet<>();
    //     List<Integer> ls = new ArrayList<>();
    //     backTack(res, ls, candidates, target);
    //     return new ArrayList<>(res);
    // }
    //
    // private void backTack(Set<List<Integer>> res, List<Integer> ls, int[] candidates, int target) {
    //     if (target == 0) {
    //         List<Integer> list = new ArrayList<>(ls);
    //         Collections.sort(list);
    //         res.add(list);
    //     }
    //     for (int i = 0; i < candidates.length; i++) {
    //         if (target >= candidates[i]) {
    //             ls.add(candidates[i]);
    //             backTack(res, ls, candidates, target - candidates[i]);
    //             ls.remove(Integer.valueOf(candidates[i]));
    //         }
    //     }
    // }
}
