package leetCode;


import java.util.Arrays;

/**
 * 757. ���ý�����С����Ϊ2
 * һ����������?[a, b]??(?a < b?) �����Ŵ�?a?��?b?��������������������?a?��?b��
 * <p>
 * ����һ����������intervals�����ҵ�һ����С�ļ��� S��ʹ�� S ���Ԫ��������intervals�е�ÿһ���������䶼������2��Ԫ���ཻ��
 * <p>
 * ��������С����S�Ĵ�С��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/set-intersection-size-at-least-two
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_757 {

    public static void main(String[] args) {


    }

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[1] > e2[1] ? 1 : (e1[1] == e2[1] ? (e1[0] - e2[0]) : -1));
        int res = 2, v1 = intervals[0][1] - 1, v2 = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > v2) {
                res += 2;
                v1 = intervals[i][1]-1;
                v2 = intervals[i][1];
            } else if (v1 < intervals[i][0] && intervals[i][0] <= v2) {
                if (v2 < intervals[i][1]) {
                    v1 = v2;
                    v2 = intervals[i][1];
                } else {
                    v1 = intervals[i][1] - 1;
                }
                res++;
            }
        }
        return res;
    }
}
