package leetCode;

/**
 * @author hjj199612
 * @date 2021/8/15 4:26 下午
 * @description 576. 出界的路径数
 */
public class Solution_576 {

    public static void main(String[] args) {

    }

    int res = 0;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (startRow < 0 || startRow >= m) {
            res++;
            return res;
        }
        if (startColumn < 0 || startColumn >= n) {
            res++;
            return res;
        }
        if (maxMove == 0) {
            return res;
        }
        if(startRow == 0)
        findPaths(m, n, maxMove - 1, startRow - 1, startColumn);
        findPaths(m, n, maxMove - 1, startRow + 1, startColumn);
        findPaths(m, n, maxMove - 1, startRow, startColumn - 1);
        findPaths(m, n, maxMove - 1, startRow, startColumn + 1);
        return res;
    }
}
