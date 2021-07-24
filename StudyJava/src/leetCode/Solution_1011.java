package leetCode;

import java.util.Arrays;

/**
 * @Description:1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-26 10:51
 **/
public class Solution_1011 {

    public static void main(String[] args) {
        int[] w = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(shipWithinDays(w, 5));
    }

    public static int shipWithinDays(int[] weights, int D) {
        // 二分查找
        int maxWeight = 0;
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
            maxWeight = Math.max(weight, maxWeight);
        }
        // 左区间
        int left = Math.max(maxWeight, sum / D);
        // 右区间
        int right = sum;
        while (left <= right) {
            int mid = (left + right) >> 1;
            // 可装载持续二分
            if (canLoad(weights, D, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 尝试以capacity进行装载
    private static boolean canLoad(int[] weights, int D, int capacity) {
        int temp = 0;
        for (int weight : weights) {
            temp += weight;
            if (temp > capacity) {
                D--;
                temp = weight;
            }
        }
        return D > 0;
    }
//        int max = 0;
//        for (int i = 0; i < weights.length; i++) {
//            if(weights[i]>max) max=weights[i];
//        }
//        while (true) {
//            int oneShip = max;
//            int num = D;
//            int i = 0;
//            while (i < weights.length && num > 0) {
//                if (oneShip >= weights[i]) {
//                    oneShip -= weights[i];
//                    i++;
//                } else {
//                    oneShip = max;
//                    num--;
//                }
//            }
//            if (i == weights.length) return max;
//            max++;
//        }

}
