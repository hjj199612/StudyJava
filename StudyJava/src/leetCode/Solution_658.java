package leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hjj
 * @date 2022/8/25 11:24
 * @description 658. �ҵ� K ����ӽ���Ԫ��
 * ����һ�� ����� ������?arr ���������� k �� x �����������ҵ���� x������֮����С���� k ���������صĽ������Ҫ�ǰ������źõġ�
 * <p>
 * ���� a ������ b ���ӽ� x ��Ҫ���㣺
 * <p>
 * |a - x| < |b - x| ����
 * |a - x| == |b - x| �� a < b
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/find-k-closest-elements
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
