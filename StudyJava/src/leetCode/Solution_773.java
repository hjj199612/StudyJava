package leetCode;

import java.util.*;

/**
 * @author huangjj24
 * @date 2021-6-26 10:04
 * 773. 滑动谜题
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * <p>
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_773 {

    public static void main(String[] args) {
        Solution_773 solution_773 = new Solution_773();
        System.out.println(solution_773.getNext(12345));
        System.out.println(solution_773.getNext(123450));
        System.out.println(solution_773.getNext(123405));
        System.out.println(solution_773.getNext(123045));
        System.out.println(solution_773.getNext(120345));
        System.out.println(solution_773.getNext(102345));

        int[][] a = {{1, 2, 3}, {4, 0, 5}};
        System.out.println(solution_773.slidingPuzzle(a));
    }

    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    private List<String> getNext(String bs) {
        List<String> ret = new ArrayList<>();
        char[] array = bs.toCharArray();
        int x = bs.indexOf('0');
        for (int y : neighbors[x]) {
            swap(array, x, y);
            ret.add(new String(array));
            swap(array, x, y);
        }
        return ret;
    }

    public void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public int slidingPuzzle(int[][] board) {
        // final String res = "123450";
        // String start = "" + board[0][0] + board[0][1] + board[0][2] + board[1][0] + board[1][1] + board[1][2];
        // int steep = 0;
        // if (start.equals(res))
        //     return steep;
        // Set<String> set = new HashSet<>();
        // Queue<String> queue = new LinkedList<>();
        // queue.add(start);
        // int size = 1;
        // while (!queue.isEmpty()) {
        //     size--;
        //     if (size == 0) {
        //         size = queue.size();
        //         steep++;
        //     }
        //     List<String> ls = getNext(queue.poll());
        //     for (String l : ls) {
        //         if (l.equals(res))
        //             return steep;
        //         if (!set.contains(l))
        //             queue.add(l);
        //     }
        //     set.addAll(ls);
        // }
        // return -1;


        final int res = 123450;
        int start = board[0][0] * 100000
                + board[0][1] * 10000
                + board[0][2] * 1000
                + board[1][0] * 100
                + board[1][1] * 10
                + board[1][2];
        int steep = 0;
        if (start == res)
            return steep;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int size = 1;
        while (!queue.isEmpty()) {
            steep++;
            for (int i = 0; i <size ; i++) {
                List<Integer> ls = getNext(queue.poll());
                for (Integer l : ls) {
                    if (l == res)
                        return steep;
                    if (!set.contains(l))
                        queue.add(l);
                }
                set.addAll(ls);
            }
            size=queue.size();
        }
        return -1;
    }

    private List<Integer> getNext(int bs) {
        List<Integer> ls = new ArrayList<>(3);
        int x5 = bs % 10;
        bs /= 10;
        int x4 = bs % 10;
        bs /= 10;
        int x3 = bs % 10;
        bs /= 10;
        int x2 = bs % 10;
        bs /= 10;
        int x1 = bs % 10;
        bs /= 10;
        int x0 = bs;
        if (x5 == 0) {
            ls.add(x2 + x4 * 10 + x3 * 100 + x1 * 10000 + x0 * 100000);
            ls.add(x4 + x3 * 100 + x2 * 1000 + x1 * 10000 + x0 * 100000);
        } else if (x4 == 0) {
            ls.add(x5 * 10 + x3 * 100 + x2 * 1000 + x1 * 10000 + x0 * 100000);
            ls.add(x5 + x3 * 10 + x2 * 1000 + x1 * 10000 + x0 * 100000);
            ls.add(x5 + x1 * 10 + x3 * 100 + x2 * 1000 + x0 * 100000);
        } else if (x3 == 0) {
            ls.add(x5 + x4 * 100 + x2 * 1000 + x1 * 10000 + x0 * 100000);
            ls.add(x5 + x4 * 10 + x0 * 100 + x2 * 1000 + x1 * 10000);
        } else if (x2 == 0) {
            ls.add(x4 * 10 + x3 * 100 + x5 * 1000 + x1 * 10000 + x0 * 100000);
            ls.add(x5 + x4 * 10 + x3 * 100 + x1 * 1000 + x0 * 100000);
        } else if (x1 == 0) {
            ls.add(x5 + x4 * 10 + x3 * 100 + x2 * 10000 + x0 * 100000);
            ls.add(x5 + x3 * 100 + x2 * 1000 + x4 * 10000 + x0 * 100000);
            ls.add(x5 + x4 * 10 + x3 * 100 + x2 * 1000 + x0 * 10000);
        } else if (x0 == 0) {
            ls.add(x5 + x4 * 10 + x3 * 100 + x2 * 1000 + x1 * 100000);
            ls.add(x5 + x4 * 10 + x2 * 1000 + x1 * 10000 + x3 * 100000);
        }
        return ls;
    }
}
