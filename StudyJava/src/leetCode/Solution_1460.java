package leetCode;

import java.util.Arrays;

/**
 * @author hjj
 * @date 2022/8/24 8:28
 * @description 1460. ͨ����ת������ʹ�����������
 * ��������������ͬ����������?target?��?arr?��ÿһ���У������ѡ��?arr?������ �ǿ�������?��������ת�������ִ�д˹�������Ρ�
 * <p>
 * ��������� arr?����� target?��ͬ������ True�����򣬷��� False ��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1460 {

    public static void main(String[] args) {

    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (arr[i] != target[i]) return false;
        }
        return true;
    }
}
