import java.util.Scanner;

/**
 * @author hjj199612
 * @date 2022/8/25 3:03 обнГ
 * @description
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String nStr = sc.nextLine();
        int n = Integer.parseInt(nStr);
        if (n == s.length() - 1 && s.contains("0")) {
            System.out.println("0");
            return;
        }
        int min = 0;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i) != '0' && s.charAt(i) < s.charAt(min)) min = i;
        }
        s = s.substring(min);
        n -= min;
        System.out.println(s.charAt(0) + getS(n, s.substring(1)));
    }

    private static String getS(int n, String s) {
        if (n == 0) return s;
        if (n == s.length()) return "";
        int min = 0;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i) < s.charAt(min)) min = i;
        }
        s = s.substring(min);
        n -= min;
        return s.charAt(0) + getS(n, s.substring(1));
    }
}
