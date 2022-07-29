package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 593. ��Ч��������
 * ����2D�ռ����ĸ��������?p1,?p2,?p3?��?p4��������ĸ��㹹��һ�������Σ��򷵻� true ��
 * <p>
 * �������?pi ��ʾΪ [xi, yi] ������ ���� ���κ�˳������ġ�
 * <p>
 * һ�� ��Ч�������� �������ȱߺ��ĸ��Ƚ�(90�Ƚ�)��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/valid-square
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_593 {

    public static void main(String[] args) {
        int[] p1 = {1, 1};
        int[] p2 = {5, 3};
        int[] p3 = {3, 5};
        int[] p4 = {7, 7};

        Solution_593 solution_593 = new Solution_593();
        System.out.println(solution_593.validSquare(p1, p2, p3, p4));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double l1 = getL(p1, p2);
        double l2 = getL(p1, p3);
        double l3 = getL(p1, p4);
        double l4 = getL(p2, p3);
        double l5 = getL(p2, p4);
        double l6 = getL(p3, p4);
        if (l1 == 0 || l2 == 0 || l3 == 0 || l4 == 0 || l5 == 0 || l6 == 0) return false;
        HashMap<Double, Integer> map = new HashMap<>();
        map.put(l1, 1);
        if (map.containsKey(l2)) map.put(l2, 2);
        else map.put(l2, 1);
        if (map.containsKey(l3)) map.put(l3, map.get(l3) + 1);
        else map.put(l3, 1);
        if (map.containsKey(l4)) map.put(l4, map.get(l4) + 1);
        else map.put(l4, 1);
        if (map.containsKey(l5)) map.put(l5, map.get(l5) + 1);
        else map.put(l5, 1);
        if (map.containsKey(l6)) map.put(l6, map.get(l6) + 1);
        else map.put(l6, 1);
        boolean flag = false;
        for (Integer value : map.values()) {
            if (value == 4) flag = true;
        }
        return flag && map.size() == 2;
    }

    private double getL(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(Math.abs(p1[0] - p2[0]), 2) + Math.pow(Math.abs(p1[1] - p2[1]), 2));
    }
}
