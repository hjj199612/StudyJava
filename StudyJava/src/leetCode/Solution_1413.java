package leetCode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 1413. ����͵õ���������Сֵ
 * ����һ���������� nums?�������ѡ�������?���� startValue ��Ϊ��ʼֵ��
 * <p>
 * ����Ҫ�����ұ��� nums?���飬���� startValue �����ۼ���?nums?�����е�ֵ��
 * <p>
 * ������ȷ���ۼӺ�ʼ�մ��ڵ��� 1 ��ǰ���£�ѡ��һ����С��?����?��Ϊ startValue ��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1413 {

    public static void main(String[] args) {

    }

    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(sum, min);
        }
        return min > 0 ? 1 : 1 - min;
    }
}
