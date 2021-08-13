package leetCode;

/**
 * @author huangjj24
 * @date 2021-8-13 8:54
 * 233. 数字 1 的个数
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 **/
public class Solution_233 {

    public static void main(String[] args) {
        Solution_233 solution_233 = new Solution_233();
        System.out.println(solution_233.countDigitOne(13));
        System.out.println((int) (Math.log10(11)));
    }

    public int countDigitOne(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}