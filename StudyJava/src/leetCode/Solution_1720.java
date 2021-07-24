package leetCode;

/**
 * @author hjj199612
 * @date 2021/5/6 8:51 下午
 * @description 1720. 解码异或后的数组
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * <p>
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * <p>
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * <p>
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1720 {

    public static void main(String[] args) {

    }

    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            arr[i+1]=encoded[i] ^ arr[i];
        }
        return arr;
    }
}
