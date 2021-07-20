package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-5-11 10:12
 * 1734. 解码异或后的排列
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * <p>
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * <p>
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-xored-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1734 {

    public static void main(String[] args) {

    }

    public int[] decode(int[] encoded) {
        int total = 0, sum = 0;
        for (int i = 1; i <= encoded.length + 1; i++) total ^= i;
        for (int i = 1; i < encoded.length; i += 2) sum ^= encoded[i];
        int[] per = new int[encoded.length + 1];
        per[0] = total ^ sum;
        for (int i = 1; i < encoded.length + 1; i++) per[i] = encoded[i - 1] ^ per[i - 1];
        return per;
    }
}
