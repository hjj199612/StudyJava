package leetCode;

/**
 * @author huangjj24
 * @date 2021-5-7 15:33
 * 1486. 数组异或操作
 * 给你两个整数，n 和 start 。
 * <p>
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * <p>
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1486 {

    public static void main(String[] args) {
        Boolean x=null;
        System.out.println(x==null);
    }

    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result ^ (start + i * 2);
        }
        return result;
    }
}
