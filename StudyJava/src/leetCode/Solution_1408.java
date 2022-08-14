package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hjj199612
 * @date 2022/8/6 10:01 ����
 * @description 1408. �����е��ַ���ƥ��
 * ����һ���ַ������� words �������е�ÿ���ַ��������Կ�����һ�����ʡ����㰴 ���� ˳�򷵻� words �����������ʵ����ַ��������е��ʡ�
 * <p>
 * ��������ɾ�� words[j]?������/�����Ҳ�������ַ��õ� word[i] ����ô�ַ��� words[i] ���� words[j] ��һ�����ַ�����
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/string-matching-in-an-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1408 {

    public static void main(String[] args) {

    }

    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) set.add(words[i]);
            }
        }
        return new ArrayList<>(set);
    }
}
