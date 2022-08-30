import java.util.Scanner;

/**
 * @author hjj199612
 * @date 2022/8/25 2:43 обнГ
 * @description
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        int[] dp = new int[arr.length];
        dp[0] = Math.max(0, arr[0]);
        if (arr.length == 1) {
            System.out.println(dp[0]);
            return;
        }
        dp[1] = Math.max(0, dp[0] + arr[1]);
        if (arr.length == 2) {
            System.out.println(dp[1]);
            return;
        }
        dp[2] = Math.max(0, dp[1] + arr[2]);
        if (arr.length == 3) {
            System.out.println(dp[2]);
            return;
        }
        for (int i = 3; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], dp[i - 3]);
        }
        System.out.println(dp[dp.length - 1]);
    }
}
