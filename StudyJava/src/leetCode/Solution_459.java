package leetCode;


/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 */
public class Solution_459 {

    public static void main(String[] args) {

    }

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i != 0) continue;
            String str = s.substring(0, i);
            int n = s.length() / i;
            StringBuilder sb = new StringBuilder();
            while (n-- > 0) sb.append(str);
            if (sb.toString().equals(s)) return true;
        }
        return false;
    }
}
