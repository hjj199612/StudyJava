package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjj199612
 * @date 2022/8/16 8:52 ����
 * @description 1656. ���������
 * �� n �� (id, value) �ԣ����� id �� 1 �� n ֮���һ��������value ��һ���ַ����������� id ��ͬ������?(id, value) �ԡ�
 * <p>
 * ���һ�������� ���� ˳���ȡ n?��?(id, value)?�ԣ����ڶ�ε���ʱ �� id ������˳�� ����һЩֵ��
 * <p>
 * ʵ�� OrderedStream �ࣺ
 * <p>
 * OrderedStream(int n) ����һ���ܽ��� n ��ֵ������������ǰָ�� ptr ��Ϊ 1 ��
 * String[] insert(int id, String value) �����д洢�µ� (id, value) �ԡ��洢��
 * ������洢�� id = ptr �� (id, value) �ԣ����ҳ��� id = ptr ��ʼ�� � id ������������ ���� ��˳�� ��������Щ id ������ֵ���б�Ȼ�󣬽� ptr ����Ϊ����Ǹ�? id + 1?��
 * ���򣬷���һ�����б�
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/design-an-ordered-stream
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1656 {

    public static void main(String[] args) {

    }

    class OrderedStream {

        private String[] values;
        int ptr = 1;

        public OrderedStream(int n) {
            values = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            values[idKey - 1] = value;
            List<String> res = new ArrayList<>();
            while (ptr <= values.length && values[ptr - 1] != null) res.add(values[ptr++-1]);
            return res;
        }
    }

}
