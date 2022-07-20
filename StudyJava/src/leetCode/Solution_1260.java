package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution_1260 {

    public static void main(String[] args) {

    }


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k %= m * n;
        List<Integer> list = new ArrayList<>(m * n);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                list.add(grid[i][j]);
            }
        }
        List<List<Integer>> res = new ArrayList<>(m);
        List<Integer> dtl = null;
        for (int i = 0; i < list.size(); i++) {
            int ind = (m * n + i - k) % (m * n);
            if (i % n == 0) {
                dtl = new ArrayList<>(n);
                res.add(dtl);
            }
            dtl.add(list.get(ind));
        }
        return res;
    }
}
