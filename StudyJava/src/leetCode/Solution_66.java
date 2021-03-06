package leetCode;

/**
 * @author huangjj24
 * @date 2021-6-17 19:25
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_66 {

    public static void main(String[] args) {
        int[] a = {9};
        plusOne(a);
    }

    public static int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i]=digits[i]%10;
            if(digits[i]%10!=0){
                return digits;
            }
        }
        digits= new int[digits.length+1];
        digits[0] = 1;
        return digits;
        // int[] res0 = new int[digits.length];
        // int r = 1;
        // for (int i = digits.length - 1; i >= 0; i--) {
        //     int x = r + digits[i];
        //     res0[i] = x % 10;
        //     r = x / 10;
        // }
        // if (r > 0) {
        //     int[] res1 = new int[digits.length + 1];
        //     res1[0] = r;
        //     for (int i = 1; i < res1.length; i++) {
        //         res1[i] = res0[i - 1];
        //     }
        //     return res1;
        // }
        // return res0;
    }
}
