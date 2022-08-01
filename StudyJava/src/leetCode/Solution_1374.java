package leetCode;

/**
 * 1374. ����ÿ���ַ��������������ַ���
 * ����һ������ n�����㷵��һ���� n ���ַ����ַ���������ÿ���ַ��ڸ��ַ����ж�ǡ�ó��� ������ ��
 * <p>
 * ���ص��ַ�������ֻ��СдӢ����ĸ��������ڶ��������ĿҪ����ַ������򷵻���������һ�����ɡ�
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1374 {

    public static void main(String[] args) {

    }

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            while (--n > 0) sb.append('a');
            sb.append('b');
        } else while (n-- > 0) sb.append('a');
        return sb.toString();
    }
}
