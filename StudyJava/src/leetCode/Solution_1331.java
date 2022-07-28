package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. �������ת������һ����������?arr �����㽫�����е�ÿ��Ԫ���滻Ϊ������������š�
 * <p>
 * ��Ŵ�����һ��Ԫ���ж����ű�ŵĹ������£�
 * <p>
 * ��Ŵ� 1 ��ʼ��š�
 * һ��Ԫ��Խ����ô���Խ���������Ԫ����ȣ���ô���ǵ������ͬ��
 * ÿ�����ֵ���Ŷ�Ӧ�þ����ܵ�С��
 * ?
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/rank-transform-of-an-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1331 {


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 1, 2};
        Solution_1331 solution_1331 = new Solution_1331();
        System.out.println(Arrays.toString(solution_1331.arrayRankTransform(arr)));

    }

    public int[] arrayRankTransform(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrCopy);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 1; i < arrCopy.length; i++) if (!map.containsKey(arrCopy[i])) map.put(arrCopy[i], j++);
        for (int i = 0; i < arr.length; i++) arr[i] = map.get(arr[i]);
        return arr;
    }
}
