package nowcoder;

//import java.util.Scanner;

/**
 * @author hjj199612
 * @date 2021/7/18 12:02 下午
 * @description
 */
public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
        int m = 2, n = 5;
        int[][][] dp = new int[m + 1][n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i][i] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = j - 1; k >= 1; k--) {
                    dp[i][j][k] += dp[i - 1][j - k][k - 1] + dp[i - 1][j - k][k];
                    if (k > 2)
                        dp[i][j][k] += dp[i - 1][j - k][k - 2];
                    if (k >= 3)
                        dp[i][j][k] += dp[i - 1][j - k][k - 3];
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += dp[m][n][i];
        }
        System.out.println(sum);
    }
}
