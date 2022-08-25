package leetCode;

/**
 * @author hjj
 * @date 2022/8/19 8:45
 * @description 1450. �ڼȶ�ʱ������ҵ��ѧ������
 * ���������������� startTime����ʼʱ�䣩�� endTime������ʱ�䣩����ָ��һ������ queryTime ��Ϊ��ѯʱ�䡣
 *
 * ��֪���� i ��ѧ���� startTime[i] ʱ��ʼд��ҵ���� endTime[i] ʱ�����ҵ��
 *
 * �뷵���ڲ�ѯʱ�� queryTime ʱ��������ҵ��ѧ����������ʽ�ϣ������ܹ�ʹ queryTime �������� [startTime[i], endTime[i]]��������ѧ��������
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1450 {

    public static void main(String[] args) {

    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
       int res=0;
        for (int i = 0; i < startTime.length; i++) {
            if(queryTime>=startTime[i]&&queryTime<=endTime[i]) res++;
        }
        return res;
    }
}
