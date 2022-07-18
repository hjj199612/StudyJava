package leetCode;

public class Solution_565 {

    public int arrayNesting(int[] nums) {
        boolean[] val = new boolean[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int curMax = 1;
            if (max > nums.length / 2)
                return max;
            if (val[i])
                continue;
            val[i] = true;
            int cur = nums[nums[i]];
            while (cur != nums[i]) {
                curMax++;
                val[cur] = true;
                cur = nums[cur];
            }
            max = max > curMax ? max : curMax;
        }
        return max;
    }
}
