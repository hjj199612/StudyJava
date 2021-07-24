package systemin;// import java.util.Scanner;
//
// public class systemin.Main {
//
//     static int sum = 0;
//
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int m = sc.nextInt();
//         int n = sc.nextInt();
//         int[][][] dp = new int[m + 1][n + 1][n + 1];
//         for (int i = 1; i <= n; i++) {
//             dp[1][i][i] = 1;
//         }
//         for (int i = 2; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 for (int k = 1; k <= n; k++) {
//                     dp[i][j][k] = dp[i - 1][j - k][k - 1] +
//                             k>=2?dp[i - 1][j - k][k - 2]:0 +
//                             k>=3?dp[i - 1][j - k][k - 3]:0 +
//                             dp[i - 1][j - k][k];
//                 }
//             }
//         }
//         int sum = 0;
//         for (int i = 1; i <= n; i++) {
//             sum += dp[m][n][i];
//         }
//         System.out.println(sum);
//     }
// }


import java.util.Scanner;

public class Main1 {

    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if (m == 1) {
            System.out.println(1);
        }
        for (int i = 1; i <= n; i++) {
            df(2, m, n - i, i);
        }
    }

    public static void df(int x, int m, int n, int last) {
        if (n <= 0) {
            return;
        }
        if (x == m) {
            if (n >= last && n <= last + 3) {
                sum++;
            }
        } else {
            df(1 + x, m, n - last, last);
            df(1 + x, m, n - last - 1, last + 1);
            df(1 + x, m, n - last - 2, last + 2);
            df(1 + x, m, n - last - 3, last + 3);
        }
    }
}


