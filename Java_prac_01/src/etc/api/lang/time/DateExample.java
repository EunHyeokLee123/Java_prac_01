package etc.api.lang.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);

        System.out.println("======================");

        // 연/월/일
        LocalDate now = LocalDate.now();
        System.out.println(now);
        
        // 현재 시각
        LocalTime now1 = LocalTime.now();
        System.out.println(now1);

        // 날짜 + 시각
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);

    }
}
