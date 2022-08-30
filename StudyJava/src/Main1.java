// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String str = sc.nextLine();
        String[] sp = str.split(",");
        for (int i = 0; i < sp.length; i++) {
            list.add(Integer.parseInt(sp[i]));
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int height = Math.min(list.get(i), list.get(j));
                res = Math.max(res, height * (j - i));
            }
        }
        System.out.println(res);
    }
}