package leetCode;

/**
 * @author hjj199612
 * @date 2022/8/14 4:35 ����
 * @description 1422. �ָ��ַ��������÷�
 * ����һ�������� 0 �� 1 ��ɵ��ַ��� s ��������㲢���ؽ����ַ����ָ������ �ǿ� ���ַ�������?�� ���ַ����� �� ���ַ��������ܻ�õ����÷֡�
 * <p>
 * ���ָ��ַ����ĵ÷֡�Ϊ �� ���ַ����� 0 ���������� �� ���ַ����� 1 ��������
 * <p>
 * <p>
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/maximum-score-after-splitting-a-string
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1422 {

    public static void main(String[] args) {
        Solution_1422 solution_1422 = new Solution_1422();
        System.out.println(solution_1422.maxScore("01001"));
    }

    public int maxScore(String s) {
        int num0 = 0, res = 0;
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '0') num0++;
        int n0 = 0, i = 0;
        if (s.charAt(i++) == '0') n0++;
        res = n0 + (s.length() - i - (num0 - n0));
        for (; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') n0++;
            int x = n0 + (s.length() - i - 1 - (num0 - n0));
            res = Math.max(x, res);
        }
        return res;
    }
}
