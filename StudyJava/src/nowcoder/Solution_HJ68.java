package nowcoder;

import java.util.Scanner;

/**
 * @author hjj
 * @date 2022/8/19 11:13
 * @description HJ68 �ɼ�����
 * ����һЩͬѧ����Ϣ�����֣��ɼ������У����㽫���ǵ���Ϣ���ճɼ��Ӹߵ��ͻ�ӵ͵��ߵ�����,��ͬ�ɼ�
 * <p>
 * ������¼��������ǰ�Ĺ�����
 * <p>
 * ��ʾ��
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 * <p>
 * �Ӹߵ���  �ɼ�
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 * <p>
 * �ӵ͵���
 * <p>
 * smith     67
 * <p>
 * jack      70
 * <p>
 * Tom       70
 * peter     96
 * <p>
 * ע��0����Ӹߵ��ͣ�1����ӵ͵���
 * <p>
 * ���ݷ�Χ��������1\le n \le 200\1��n��200
 * ���ף�ʱ�临�Ӷȣ�O(nlogn)\O(nlogn) ���ռ临�Ӷȣ�O(n)\O(n)
 * ����������
 * ��һ������Ҫ������˵ĸ���n���ڶ�������һ��������ʾ����ķ�ʽ��֮��n�зֱ��������ǵ����ֺͳɼ�����һ���ո����
 * <p>
 * ���������
 * ����ָ����ʽ������ֺͳɼ������ֺͳɼ�֮����һ���ո����
 * <p>
 * ʾ��1
 */
public class Solution_HJ68 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int symbol = Integer.parseInt(scanner.nextLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                String[] sj = arr[j].split(" ");
                String[] sj_1 = arr[j - 1].split(" ");
                if (symbol == 1) {
                    if (Integer.parseInt(sj[1]) < Integer.parseInt(sj_1[1])) {
                        String s = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = s;
                    }
                } else if (symbol == 0) {
                    if (Integer.parseInt(sj[1]) > Integer.parseInt(sj_1[1])) {
                        String s = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = s;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
