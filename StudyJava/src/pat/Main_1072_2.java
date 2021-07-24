package pat;

import java.util.Scanner;

public class Main_1072_2 {
    public static void main(String []args) {
        Scanner scn = new Scanner(System.in);
        int studentCount = scn.nextInt();
        int goodsCount = scn.nextInt();
        String[] goodsNum = new String[goodsCount];
        for (int i = 0; i < goodsCount; i++) {
            goodsNum[i] = scn.next();
        }
        scn.nextLine();
        int sc=0;
        int wc=0;
        for (int i = 0; i < studentCount; i++) {
            String[] student = scn.nextLine().split(" ");
            int count = 0;
            String bh = "";
            for (int x = 1; x < student.length; x++) {
                for (int j = 0; j < goodsCount; j++) {
                    if (student[x].equals(goodsNum[j])) {
                        count++;
                        bh += student[x] + " ";
                    }
                }
            }
            if (count != 0) {
                System.out.println(student[0] + ": " + bh.substring(0, bh.length() - 1));
                sc++;
                wc+=count;
            }
        }
        System.out.print(sc + " " + wc);
    }

}
