package nowcoder;

import java.util.Scanner;

/**
 * @author hjj199612
 * @date 2021/7/24 5:39 下午
 * @description
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] versions = str.split(" ");
        String[] v1 = versions[0].split("\\.");
        String[] v2 = versions[1].split("\\.");
        int i = 0;
        while (i < v1.length || i < v2.length) {
            String s1 = "", s2 = "";
            if (i < v1.length) {
                s1 = v1[i];
            }
            if (i < v2.length) {
                s2 = v2[i];
            }
            int res = compare(s1, s2);
            if (res != 0) {
                System.out.println(res);
                return;
            } else i++;
        }
            System.out.println(0);
    }


    public static int compare(String s1, String s2) {
        while (s1.startsWith("0")) {
            s1 = s1.substring(1);
        }
        while (s2.startsWith("0")) {
            s2 = s2.substring(1);
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int i = 0;
        while (i < c1.length && i < c2.length) {
            if (c1[i] > c2[i]) {
                return 1;
            } else if (c1[i] < c2[i]) {
                return -1;
            }
            i++;
        }
        if (i < c1.length) {
            for (; i < c1.length; i++) {
                if (c1[i] != '0') {
                    return 1;
                }
            }
        }
        if (i < c2.length) {
            for (; i < c2.length; i++) {
                if (c2[i] != '0') {
                    return -1;
                }
            }
        }
        return 0;
    }
}
