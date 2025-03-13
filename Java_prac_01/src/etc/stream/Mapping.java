package etc.stream;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static etc.stream.Menu.*;

public class Mapping {
    public static void main(String[] args) {

        // map : 리스트에서 원하는 데이터만 추출
        // original : [ {}, {}, {}, {}, {} ]
        // filter   : [ {}, {}, {} ]
        // map      : [ "", "", "", "", "" ]


        // toList는 간단한 출력 정도일 때만 사용하는 것이 좋음.
        menuList.stream()
                .map(new Function<Dish, String>() {
                    @Override
                    public String apply(Dish dish) {
                        return dish.getName();
                    }
                })
                .toList()
                .forEach(System.out::println);

        System.out.println("===============================");

        // 요리 이름만 출력
        // toList()는 Java16부터 사용가능
        // 리턴되는 리스트는 고정리스트임.(수정이 불가능)
        //  .collect(Collectors.toList())는 Java8 부터 사용가능
        // 그리고 고정형 리스트가 아님 -> 수정이 자유로움
        menuList.stream()
                .map(d-> d.getName())
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("=============================");

        List<String> Exp = List.of("chrome", "safari", "ms edge", "opera", "firefox");

        // 문자들의 길이만 추출
        List<Integer> len = Exp.stream()
                .map(String::length)
                .toList();
        for (Integer i : len) {
            System.out.println(i);
        }

        List<Character> len2 = Exp.stream()
                .map(d -> d.charAt(0))
                .collect(Collectors.toList());

        // len.add(66);
        len2.add('A');

        System.out.println("===============================");
        // 메뉴 목록에서 메뉴 이름과 칼로리만 추출해서
        // 새로운 객체로 포장해서 받고 싶음

        List<SimpleDish> simli = menuList.stream()
                .map(d ->
                        new SimpleDish(d.getName(), d.getCalories()))
                .toList();

        List<SimpleDish> simli2 = menuList.stream()
                .map(d -> new SimpleDish(d))
                .toList();


        for (SimpleDish simpleDish : simli2) {
            System.out.println(simpleDish);
        }

        System.out.println("===========================");

                /*
            메뉴 목록에서 칼로리가 500칼로리보다 큰
            음식들을 필터링한 다음에 음식의 이름과 타입만
            추출해서 출력해주세요.
            클래스를 하나 만들어서  포장 -> DishDetail
            단, 타입은 MEAT의 경우 육류라고 저장
            FISH는 어류라고 저장, OTHER는 기타라고 저장
         */

        List<DishDetail> detailList = menuList.stream()
                .map(DishDetail::new)
                .toList();

        for (DishDetail dishDetail : detailList) {
            System.out.println(dishDetail);
        }

        // 메뉴 목록의 총 칼로리 계산
        int totalCal = menuList.stream()
                .mapToInt(d -> d.getCalories())
                .sum();

        // 육류 메뉴의 평균 칼로리 계산하기
        double asDouble = menuList.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .mapToInt(d -> d.getCalories())
                .average()
                .getAsDouble();

        System.out.println("asDouble = " + asDouble);
    }
}
