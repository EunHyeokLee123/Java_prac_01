package etc.stream.quiz;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );

        // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).

        transactions.stream()
                .filter(d->d.getYear() == 2021)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList()
                .forEach(System.out::println);

        System.out.println("=================================");

        // 연습 2: 거래자가 근무하는 모든 도시이름을 중복 없이 나열하시오.

        transactions.stream()
                .map(d->d.getTrader().getCity())
                .distinct()
                .toList()
                .forEach(System.out::println);

        // toset을 통해 set으로 받을 수 있음. 중복 방지
        transactions.stream()
                        .map(d->d.getTrader().getCity())
                        .collect(Collectors.toSet())
                        .forEach(System.out::println);


        System.out.println("=============================");

        // 연습 3: Cambridge에 근무하는 모든 거래자(Trader)를 찾아
        // 거래자 리스트로 이름순으로 오름차 정렬.

        transactions.stream()
                // .equalsIgnoreCase -> 대소문자 구분 없이 스펠링만 동일하면 동일처리
                .filter(d-> d.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(d->d.getTrader().getName()))
                .toList()
                .forEach(System.out::println);

        System.out.println("=================================");

        // 연습 4: 모든 거래자의 이름을 리스트에 모아서
        // 알파벳순으로  오름차 정렬하여 반환

        List<String> list = transactions.stream()
                .map(d -> d.getTrader().getName())
                .distinct()
                .sorted()
                .toList();

        System.out.println(list.toString());

        System.out.println("===============================");

        // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?

        boolean milan = transactions.stream()
                .anyMatch(d -> d.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
        System.out.println("=========================");

        // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.

        int sum = transactions.stream()
                .filter(d -> d.getTrader().getCity().equals("Cambridge"))
                .mapToInt(d -> d.getValue())
                .sum();
        System.out.println("sum = " + sum);
        System.out.println("===============================");

        // 연습 7: 모든 거래에서 최고거래액은 얼마인가?

        int max = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .getAsInt();
        System.out.println("max = " + max);
        System.out.println("=============================");

        // 연습 8. 가장 작은 거래액을 가진 거래정보 탐색
        int min = transactions.stream()
                .mapToInt(Transaction::getValue)
                .min()
                .getAsInt();
        System.out.println("min = " + min);
        System.out.println("==========================");

        // 연습 9. 거래액이 500 이상인 거래들만 필터링하고,
        // 해당 거래의 정보를 출력하시오.

        transactions.stream()
                .filter(d->d.getValue()>500)
                .toList()
                .forEach(System.out::println);
        System.out.println("=============================");

        // 연습 10. 모든 거래에서 가장 작은 거래액보다
        // 큰 거래액을 가진 거래의 평균을 계산하시오.
        // 출력값: 752.0

        double asDouble = transactions.stream()
                .filter(d -> d.getValue() > min)
                .mapToInt(Transaction::getValue)
                .average()
                .getAsDouble();
        System.out.println("평균 = " + asDouble);
        System.out.println("===========================");

        // 연습 11. cambridge에 근무하는 모든 트레이더의 내역을 연도별로 분류
        /*
        Year: 2021
        {Trader: Brian in Cambridge, year: 2021, value: 300}
        {Trader: Raoul in Cambridge, year: 2021, value: 400}
        ...

        Year: 2022
        {Trader: Raoul in Cambridge, year: 2022, value: 1000}
        ...
         */

        // key: 거래연도, value: 거래내역을 담은 리스트
        HashMap<Integer, List<Transaction>> groupByYearMap = new HashMap<>();

        List<Transaction> trs2021 = transactions.stream()
                .filter(trs -> trs.getYear() == 2021)
                .toList();

        List<Transaction> trs2022 = transactions.stream()
                .filter(trs -> trs.getYear() == 2022)
                .toList();

        groupByYearMap.put(2021, trs2021);
        groupByYearMap.put(2022, trs2022);

        Map<Integer, List<Transaction>> camTr = transactions.stream()
                .filter(d -> d.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.groupingBy(Transaction::getYear));
        camTr.forEach((key, value) -> {
            System.out.println("Year: "+key);
            value.forEach(System.out::println);
        });

    }

}
