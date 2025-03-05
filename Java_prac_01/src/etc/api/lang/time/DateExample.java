package etc.api.lang.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

        // 연,월,일,시,분,초
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);

        System.out.println("============================");

        // 특정 날짜와 시간 정보 얻기
        LocalDateTime.of(2022,7,1,8,9,11);

        // 지금으로부터 3일 뒤
        LocalDateTime d1 =  now2.plusDays(3);
        System.out.println(d1);
        d1 = d1.plusYears(2).plusMonths(4);

        System.out.println(d1);
        LocalDateTime d2 = now2.plusDays(-3).plusYears(-6).plusMonths(-2);
        System.out.println(d2);
        
        // 사이 날짜 연산 (일, 월, 연, decade, 세기도 계산가능)
        LocalDate past = LocalDate.of(2020, 12, 30);
        LocalDate future = LocalDate.of(2029, 5, 14);
        long between = ChronoUnit.DAYS.between(past, future);
        long between1 = ChronoUnit.WEEKS.between(past, future);
        System.out.println("between = " + between);
        System.out.println("between1 = " + between1);

        System.out.println("========================");

        // 날짜 포맷 변경하기
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
        // 준비한 DataTimeFormatter 객체를 format의 매개값으로 전달
        String re = now2.format(dtf);
        System.out.println(re);
    }
}
