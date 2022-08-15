package leetCode;


/**
 * 459. �ظ������ַ���
 * ����һ���ǿյ��ַ��� s ������Ƿ����ͨ��������һ���Ӵ��ظ���ι��ɡ�
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
