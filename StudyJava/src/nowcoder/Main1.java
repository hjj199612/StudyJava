package nowcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hjj199612
 * @date 2021/7/24 5:39 下午
 * @description
 */
public class Main1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1};
        Main1 main1 = new Main1();
        System.out.println(main1.majorityElement(arr));
    }

    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
//            if (e.getValue() > nums.length / 2) {
//                return e.getKey();
//            }
//        }
//        return -1;

        int res = nums[0], count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    res = nums[i];
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == res) {
                count++;
            }
        }
        return count > nums.length / 2 ? res : -1;
    }

}
