package leetCode;

/**
 * @author hjj
 * @date 2022/8/26 9:16
 * @description 1464. ��������Ԫ�ص����˻�
 * ����һ���������� nums������ѡ�������������ͬ�±� i �� j��ʹ (nums[i]-1)*(nums[j]-1) ȡ�����ֵ��
 * <p>
 * ������㲢���ظ�ʽ�����ֵ��
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1464 {

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int i = 0, j = 1;
        for (int k = 2; k < nums.length; k++) {
            int max = nums[i] > nums[j] ? i : j;
            int min = max == i ? (nums[j] > nums[k] ? k : j) : (nums[i] > nums[k] ? k : i);
            i = i != min ? i : k;
            j = j != min ? j : k;
        }
        return (nums[i] - 1) * (nums[j] - 1);
    }
}
