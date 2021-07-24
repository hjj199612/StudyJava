package leetCode;

import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

/**
 * @author huangjj24
 * @date 2021-7-2 8:55
 * 1833. 雪糕的最大数量
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * <p>
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * <p>
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * <p>
 * 注意：Tony 可以按任意顺序购买雪糕。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-ice-cream-bars
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1833 implements Serializable {
class SSS extends Solution_1833{

}
    public static void main(String[] args) throws InterruptedException {
        int[] a = {7, 3, 3, 6, 6, 6, 10, 5, 9, 2};
        Solution_1833 solution_1833 = new Solution_1833();
        synchronized (solution_1833){
            solution_1833.wait(1);
        }
        try (Scanner scanner = new Scanner(new File("test.txt"))) {

        }catch (Exception exception ){

        }
        Class c1 = solution_1833.getClass();
        Class c2 = Solution_1833.class;
        Class c3 = SSS.class;
        System.out.println(c1==c2);
        System.out.println(c2==c3);
        // System.out.println(solution_1833.maxIceCream(a,  56));
    }

    public int maxIceCream(int[] costs, int coins) {
        for (int i = costs.length / 2 - 1; i >= 0; i--) {
            heap(costs, i, costs.length);
        }
        int count = 0;
        while (count < costs.length && coins >= costs[0]) {
            coins -= costs[0];
            swap(costs, 0, costs.length - 1 - count);
            count++;
            heap(costs, 0, costs.length - count);
        }
        return count;
        // Arrays.sort(costs);
        // int count = 0;
        // while (count < costs.length && coins >= costs[count]) {
        //     coins -= costs[count++];
        // }
        // return count;
    }

    private void heap(int[] costs, int i, int length) {
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && costs[j + 1] < costs[j])
                j++;
            if (costs[i] > costs[j]) {
                swap(costs, i, j);
                i = j;
            } else
                break;
        }
    }

    private void swap(int[] costs, int i, int j) {
        int temp = costs[i];
        costs[i] = costs[j];
        costs[j] = temp;
    }
}
