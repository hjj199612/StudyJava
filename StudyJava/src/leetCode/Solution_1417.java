package leetCode;

/**
 * @author hjj199612
 * @date 2022/8/12 11:27 ионГ
 * @description
 */
public class Solution_1417 {

    public static void main(String[] args) {

    }

    public String reformat(String s) {
        StringBuilder sba = new StringBuilder();
        StringBuilder sb0 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') sb0.append(c);
            if (c >= 'a' && c <= 'z') sba.append(c);
        }
        if (Math.abs(sba.length() - sb0.length()) > 1) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean flag = sba.length() > sb0.length();
        for (; i < sba.length() && i < sb0.length(); i++) {
            if (flag) sb.append(sba.charAt(i)).append(sb0.charAt(i));
            else sb.append(sb0.charAt(i)).append(sba.charAt(i));
        }
        if (i < sba.length()) sb.append(sba.charAt(i));
        if (i < sb0.length()) sb.append(sb0.charAt(i));
        return sb.toString();
    }
}
