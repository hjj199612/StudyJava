package src.pat;

import java.util.Scanner;

public class Main_1028_2 {
    public static void main(String []args){
        Scanner scn=new Scanner(System.in);
        String young="2014/09/06";
        String old="1814/09/06";
        int num=0;
        String youngest=old;
        String oldest=young;
        String youngName="",oldName="";
        int n=scn.nextInt();
        for(int i=0;i<n;i++) {
            String name=scn.next();
            String date=scn.next();
            if(date.compareTo(young)<=0 && date.compareTo(old)>=0) {
                num++;
                if(date.compareTo(oldest)<0) {
                    oldest=date;
                    oldName=name;

                }
                if(date.compareTo(youngest)>0) {
                    youngest=date;
                    youngName=name;
                }
            }
        }
        System.out.print(num+" "+oldName+" "+youngName);
    }
}
