package leetCode;

import java.util.List;

/**
 * @author hjj
 * @date 2022/8/22 9:05
 * @description 655. ���������
 * <p>
 * ����һ�ö������ĸ��ڵ� root �����㹹��һ���±�� 0 ��ʼ����СΪ m x n ���ַ������� res �����Ա�ʾ���� ��ʽ������ ������˸�ʽ�����־�����Ҫ��ѭ���¹���
 * <p>
 * ���� �߶� Ϊ height ����������� m Ӧ�õ��� height + 1 ��
 * ��������� n Ӧ�õ��� 2height+1 - 1 ��
 * ���ڵ� ��Ҫ������ ���� �� ���м� ����Ӧλ��Ϊ res[0][(n-1)/2] ��
 * ���ڷ����ھ����е�ÿ���ڵ㣬���Ӧλ��Ϊ res[r][c] ���������ӽڵ������ res[r+1][c-2height-r-1] �����ӽڵ������ res[r+1][c+2height-r-1] ��
 * ������һ���̣�ֱ�����е����нڵ㶼���Ʒ��á�
 * ����յ�Ԫ��Ӧ�ð������ַ��� "" ��
 * ���ع���õ��ľ��� res ��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/print-binary-tree
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_655 {

    public static void main(String[] args) {

    }

    public List<List<String>> printTree(TreeNode root) {
        return null;
    }
}
