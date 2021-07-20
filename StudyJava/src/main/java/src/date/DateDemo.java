package src.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.YEARS;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-12 20:49
 **/
public class DateDemo {
    public static void main(String[] args) {
//        LocalDate today = LocalDate.now();
//        LocalDate plusYears = today.plusYears(1);
//        LocalDate plusYears1 = today.minusYears(1);
//        System.out.println(today);
//        System.out.println(plusYears);
//        System.out.println(plusYears1);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(localDateTime.format(formatter));


        LocalDateTime birth = LocalDateTime.of(1996,12,11,12,12,12,12);

        Duration duration = Duration.between(localDateTime,birth);
//        System.out.println(duration.get(YEARS));//不支持
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());








    }
}
