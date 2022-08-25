package leetCode;

/**
 * @author hjj
 * @date 2022/8/22 9:34
 * @description 1480. һά����Ķ�̬��
 * ����һ������ nums �����顸��̬�͡��ļ��㹫ʽΪ��runningSum[i] = sum(nums[0]��nums[i]) ��
 * <p>
 * �뷵�� nums �Ķ�̬�͡�
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/running-sum-of-1d-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1480 {

    public static void main(String[] args) {

    }

    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }
        return runningSum;
    }
}
