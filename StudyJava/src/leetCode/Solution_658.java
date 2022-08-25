package leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hjj
 * @date 2022/8/25 11:24
 * @description 658. 找到 K 个最接近的元素
 * 给定一个 排序好 的数组?arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_658 {

    public static void main(String[] args) {

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                res.addLast(arr[i]);
                continue;
            }
            int absFirst = Math.abs(res.getFirst() - x);
            int absArr = Math.abs(arr[i] - x);
             res.removeFirst();
            res.addLast(arr[i]);
        }
        return res;
    }
}
