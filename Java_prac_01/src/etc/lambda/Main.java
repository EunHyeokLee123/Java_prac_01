package etc.lambda;

import java.util.List;

// static 필드나 메서드를 클래스 이름 없이 호출하기 위한 import
import static etc.lambda.Color.*;
import static etc.lambda.FilterApple.*;

public class Main {
    public static void main(String[] args) {

        // 사과 바구니 생성
        List<Apple> appleBasket = List.of(
                new Apple(80, GREEN)
                , new Apple(155, GREEN)
                , new Apple(120, RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );

        System.out.println("===============녹색 사과만 필터링=============");

        List<Apple> greens = filterGreen(appleBasket);
        for (Apple green : greens) {
            System.out.println(green);
        }

        System.out.println("===============원하는 조건의 사과만 필터링=============");
        List<Apple> lightApple =
        filterApple(appleBasket, new ApplePredict());
        System.out.println(lightApple);

        System.out.println("==================================");
        // 빨강 또는 노랑 사과만 필터링
        // 매번 클래스를 만드는 것은 비효율적
        // 메소드 선언할 때 이름 없는 클래스를 즉석에서 선언해서 보내주자! -> 익명 클래스
        List<Apple> app = filterApple(appleBasket, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == RED ||
                        apple.getColor() == YELLOW;
            }
        });
        for (Apple apple : app) {
            System.out.println(apple);
        }

        System.out.println("=========LAmBDA==============");
        // 익명 클래스를 통해, 새 클래스 생성 없이 즉석에서 사용
        // 인터페이스에 추상 메소드가 하나면 람다로 사용 가능
        filterApple(appleBasket,
                (apple -> {
                    return apple.getColor() == GREEN &&
                            apple.getWeight() <= 100;
                })
                );

        // 위의 인터페이스 매개변수를 람다식으로 한줄 표현
        List<Apple> app2 = filterApple(appleBasket,
                (apple ->
                        apple.getWeight() <= 100 &&
                                apple.getColor() == GREEN)
        );

        for (Apple apple : app2) {
            System.out.println(apple);
        }

        // 색깔이 빨강 혹은 초록이면서, 무게는 150g미만
        List<Apple> app3 = filterApple(appleBasket, (apple ->
                (apple.getColor() == RED || apple.getColor() == GREEN) &&
                        apple.getWeight() < 150));

        for (Apple apple : app3) {
            System.out.println(apple);
        }

        System.out.println("============여러가지 타입의 객체를 필터링============");
        List<Integer> num = List.of(1,2,3,4,5,6,7,8,9,10);

        List<Integer> it = filterAny(num, i -> i % 2 == 1);

        for (Integer i : it) {
            System.out.println(i);
        }
    }
}
