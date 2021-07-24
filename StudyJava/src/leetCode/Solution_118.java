package leetCode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjj24
 * @date 2021-6-24 13:42
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 **/
public class Solution_118 {

    public static void main(String[] args) {
        Solution_118 solution_118 = new Solution_118();
        System.out.println(solution_118.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> ls = new ArrayList<>(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    ls.add(1);
                } else {
                    ls.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(ls);
        }
        return res;
    }
}
