package nowcoder;

import java.util.Scanner;

/**
 * @author hjj
 * @date 2022/8/19 11:13
 * @description HJ68 成绩排序
 * 给定一些同学的信息（名字，成绩）序列，请你将他们的信息按照成绩从高到低或从低到高的排列,相同成绩
 * <p>
 * 都按先录入排列在前的规则处理。
 * <p>
 * 例示：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 * <p>
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 * <p>
 * 从低到高
 * <p>
 * smith     67
 * <p>
 * jack      70
 * <p>
 * Tom       70
 * peter     96
 * <p>
 * 注：0代表从高到低，1代表从低到高
 * <p>
 * 数据范围：人数：1\le n \le 200\1≤n≤200
 * 进阶：时间复杂度：O(nlogn)\O(nlogn) ，空间复杂度：O(n)\O(n)
 * 输入描述：
 * 第一行输入要排序的人的个数n，第二行输入一个整数表示排序的方式，之后n行分别输入他们的名字和成绩，以一个空格隔开
 * <p>
 * 输出描述：
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 * <p>
 * 示例1
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
