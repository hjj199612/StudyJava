package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hjj199612
 * @date 2022/8/12 11:14 ����
 * @description 1282. �û�����
 * ��?n?���˱��ֳ�����δ֪���顣ÿ���˶������Ϊһ���� 0 �� n - 1 ��ΨһID?��
 * <p>
 * ����һ���������� groupSizes ������?groupSizes[i]?�ǵ� i �������ڵ���Ĵ�С�����磬���?groupSizes[1] = 3?����� 1 ���˱���λ�ڴ�СΪ 3 �����С�
 * <p>
 * ����һ�����б�ʹÿ���� i ����һ����СΪ?groupSizes[i]?�����С�
 * <p>
 * ÿ����Ӧ��?ǡ��ֻ?������?һ����?�У�����ÿ���˱�����һ�����С�����ж���𰸣���������?�κ�?һ��������?��֤?��������?������һ��?��Ч�Ľ⡣
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1282 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) map.put(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        map.forEach((k, v) -> {
            List<Integer> resDtl = new ArrayList<>();
            for (int i = 0; i < v.size(); i++) {
                resDtl.add(v.get(i));
                if (resDtl.size() == k) {
                    res.add(resDtl);
                    resDtl = new ArrayList<>();
                }
            }
        });
        return res;
    }
}
