package nowcoder;

/**
 * @author hjj199612
 * @date 2021/7/24 5:39 下午
 * @description
 */
public class Main2 {

    public int missingNumber(int[] nums) {
        // write code here
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

}
