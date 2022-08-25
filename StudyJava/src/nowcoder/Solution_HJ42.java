package nowcoder;

import java.util.Scanner;

/**
 * @author hjj
 * @date 2022/8/19 10:15
 * @description HJ42 ѧӢ��
 * ����
 * Jessi��ѧӢ�Ϊ�˿��ٶ���һ�����֣���д��������ת����Ӣ�ģ�
 * <p>
 * �����������:
 * 1.��Ӣ���������λ���ֿ���һ���壬�����ټ�һ��������λ�������ұ�����������λһ��λ������12,345 ��
 * 2.ÿ��λ����ǵô��ϼ�����λ �ֱ���thousand, million, billion.
 * 3.��ʽ����������ǧ���ϵ��� X thousand X, 10�����°������ϵ�����X million X thousand X, 10 �����ϵ�����X billion X million X thousand X. ÿ��X�ֱ������λ������λ����һλ����
 * 4.��ӢʽӢ���а�λ����ʮλ��֮��Ҫ��and����ʽӢ�������ʡ�ԣ����������Ŀ���ü���and���ٷ�λΪ��Ļ��������Ŀ����ʡ��and
 * <p>
 * �����ٿ������������䣺
 * 22: twenty two
 * 100:  one hundred
 * 145:  one hundred and forty five
 * 1,234:  one thousand two hundred and thirty four
 * 8,088:  eight thousand (and) eighty eight (ע:���and�ɼӿɲ��ӣ������Ŀ����ѡ�񲻼�)
 * 486,669:  four hundred and eighty six thousand six hundred and sixty nine
 * 1,652,510:  one million six hundred and fifty two thousand five hundred and ten
 * <p>
 * ˵����
 * ����Ϊ��������������С����ת�����ΪӢ��Сд��
 * ��֤��������ݺϷ�
 * �ؼ�����ʾ��and��billion��million��thousand��hundred��
 * <p>
 * ���ݷ�Χ��1 \le n \le 2000000 \1��n��2000000
 */
public class Solution_HJ42 {
    private static String[] arr1 = {"thousand", "million", "billion"};
    private static String[] arr2 = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    private static String[] arr3 = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static String[] arr4 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder sb0 = new StringBuilder();
        for (int i = s.length()-1,j=0; i >=0; i--) {
            sb0.append(s.charAt(i));
            if(++j%3==0&&i!=0) {
                sb0.append(',');
            }
        }
        String[] split = sb0.reverse().toString().split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(get3(split[i]));
            if (split.length - i == 1) break;
            sb.append(" ").append(arr1[split.length - i - 2]);
        }
        System.out.println(sb);
    }

    private static String get3(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() == 3) {
            if (s.charAt(0) != '0') {
                sb.append(arr2[s.charAt(0) - '0']).append(" hundred ");
                if (s.charAt(1) != '0' || s.charAt(2) != '0') sb.append("and ");
            }
        }
        sb.append(get2(s));
        return sb.toString();
    }

    private static String get2(String s) {
        if (s.length() == 3) s = s.substring(1);
        if ("00".equals(s)) return "";
        if (s.length() == 2) {
            if (s.charAt(0) == '0') return arr2[s.charAt(1) - '0'];
            else if (s.charAt(0) == '1') return arr3[s.charAt(1) - '0'];
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(arr4[s.charAt(0) - '2']);
                if (s.charAt(1) != '0') sb.append(" ").append(arr2[s.charAt(1) - '0']);
                return sb.toString();
            }
        } else {
            return arr2[s.charAt(0) - '0'];
        }
    }


}
