package leetCode;


import java.util.*;

/**
 * 1224. ������Ƶ��
 * ����һ������������?nums�������æ�Ӹ��������ҳ�����������Ҫ��� � ǰ׺�������ظ�ǰ׺�ĳ��ȣ�
 * <p>
 * ��ǰ׺�� ǡ��ɾ��һ�� Ԫ�غ�ʣ��ÿ�����ֵĳ��ִ�������ͬ��
 * ���ɾ�����Ԫ�غ�û��ʣ��Ԫ�ش��ڣ��Կ���Ϊÿ�����ֶ�������ͬ�ĳ��ִ�����Ҳ���� 0 �Σ���
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/maximum-equal-frequency
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Solution_1224 {

    public static void main(String[] args) {
        Solution_1224 solution_1224 = new Solution_1224();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        System.out.println(solution_1224.maxEqualFreq(arr));
    }

    public int maxEqualFreq(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        Map<Integer, Integer> set = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> value = entry.getValue();
                int num = value.size();
                for (int j = value.size() - 1; j >= 0; j--) {
                    if (value.get(j) > i) num--;
                    else break;
                }
                if (num != 0) {
                    if (!set.containsKey(num)) set.put(num, 0);
                    set.put(num, set.get(num) + 1);
                }
                if (set.size() > 2) break;
            }
            if (set.size() == 1 && (set.containsKey(1) || set.containsValue(1))) return i + 1;
            if (set.size() == 2) {
                Map.Entry<Integer, Integer>[] arr = set.entrySet().toArray(new Map.Entry[2]);
                Integer key0 = Math.min(arr[0].getKey(), arr[1].getKey());
                Integer key1 = Math.max(arr[0].getKey(), arr[1].getKey());
                if (key0 == 1) {
                    if (set.get(key0) == 1 || (key1 == 2 && set.get(key1) == 1)) return i + 1;
                } else if (key1 - key0 == 1 && arr[1].getValue() == 1) return i + 1;
            }
            set = new HashMap<>();
        }
        return 0;
    }
}
