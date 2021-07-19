package src.leetCode;

import java.util.*;

/**
 * @author huangjj24
 * @date 2021-6-5 13:37
 * 36. 有效的数独
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_36 {

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("" + '1'));
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Character, List<String>> map = new HashMap<>();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (board[x][y] != '.') {
                    Character c = board[x][y];
                    List<String> list = map.getOrDefault(c, new ArrayList<>());
                    list.add(x + "" + y);
                    map.put(c, list);
                    if (!isValidSudoku(list))
                        return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku(List<String> list) {
        Set<Character> setX = new HashSet<>();
        Set<Character> setY = new HashSet<>();
        for (String s : list) {
            if (!setX.add(s.charAt(0)) || !setY.add(s.charAt(1)))
                return false;
            int sx = Integer.parseInt("" + s.charAt(0));
            int sy = Integer.parseInt("" + s.charAt(1));
            for (String r : list) {
                if (s.equals(r))
                    continue;
                int rx = Integer.parseInt("" + r.charAt(0));
                int ry = Integer.parseInt("" + r.charAt(1));
                if (sx / 3 == rx / 3 && sy / 3 == ry / 3)
                    return false;
            }
        }
        return true;
    }
}
