package leetCode;

import java.util.Arrays;

/**
 * 899. �������
 * ����һ���ַ��� s ��һ������ k?������Դ� s ��ǰ k ����ĸ��ѡ��һ�����������ӵ��ַ�����ĩβ��
 * <p>
 * ���� ��Ӧ����������������������ƶ����ֵ�����С���ַ���?��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/orderly-queue
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_899 {

    public static void main(String[] args) {

    }

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String min = s;
            StringBuilder sb = new StringBuilder(min);
            for (int i = 0; i < s.length(); i++) {
                String substring = sb.append(sb.charAt(0)).substring(1);
                if (min.compareTo(substring) > 0) min = substring;
                sb = new StringBuilder(substring);
            }
            return min;
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }
}
