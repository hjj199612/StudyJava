package leetCode;

/**
 * @author huangjj24
 * @date 2021-7-30 8:51
 * 171. Excel表列序号
 **/
public class Solution_171 {

    public static void main(String[] args) {
        Solution_171 solution_171 = new Solution_171();
        System.out.println(solution_171.titleToNumber("AB"));
    }

    public int titleToNumber(String columnTitle) {
        int res = 0, n = columnTitle.length();
        for (int i = 0; i < n; i++) {
            res = res * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return res;
    }
}
