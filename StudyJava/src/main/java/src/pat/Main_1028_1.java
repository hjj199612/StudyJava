package src.pat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main_1028_1 {

    public static void main(String[] args) throws ParseException {
        // TODO Auto-generated method stub
        final String LONG_DTE_FORMAT = "yyyy/MM/dd";
        SimpleDateFormat formater = new SimpleDateFormat(LONG_DTE_FORMAT);
        Date date=formater.parse("2014/09/06");
        Date date2=formater.parse("1814/09/06");
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int num=0;
        Date young=date2,old=date;
        String youngString="",oldString="";
        Date date3;
        for(int i=0;i<n;i++) {
            String name=scn.next();
            date3=formater.parse(scn.next());
            if(date3.equals(date2)||date3.equals(date)||(date3.after(date2)&&date3.before(date))) {
                num++;
                if(date3.before(old)) {
                    old=date3;
                    oldString=name;
                }
                if(date3.after(young)) {
                    young=date3;
                    youngString=name;
                }
            }
        }
        System.out.print(num+" "+oldString+" "+youngString);
    }
}

