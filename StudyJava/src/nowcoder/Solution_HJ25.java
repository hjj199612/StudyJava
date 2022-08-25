package nowcoder;

import java.util.*;

/**
 * @author hjj
 * @date 2022/8/18 12:51
 * @description HJ25 数据分类处理
 * 信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
 * <p>
 * 采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。
 */
public class Solution_HJ25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iN = scanner.nextInt();
        Integer[] arrI = new Integer[iN];
        for (int i = 0; i < arrI.length; i++) arrI[i] = scanner.nextInt();
        int rN = scanner.nextInt();

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < rN; i++) set.add(scanner.nextInt());
        Integer[] arrR = set.toArray(new Integer[set.size()]);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrR.length; i++) {
            boolean flag = false;
            List<Integer> ls = new ArrayList<>();
            for (int j = 0; j < arrI.length; j++) {
                if (arrI[j].toString().contains(arrR[i].toString())) {
                    ls.add(j);
                    ls.add(arrI[j]);
                    flag = true;
                }
            }
            if (flag) {
                list.add(arrR[i]);
                list.add(ls.size() / 2);
                list.addAll(ls);
            }
        }
        System.out.print(list.size() + " ");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }


}
