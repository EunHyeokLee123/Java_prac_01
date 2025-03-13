package etc.stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static etc.stream.Menu.*;

public class Filtering {
    public static void main(String[] args) {

        List<Dish> dishList = menuList.stream()
                .filter(Dish::isVegetarian)
                .toList();

        dishList.forEach(new Consumer<Dish>() {
            @Override
            public void accept(Dish dish) {
                System.out.println(dish);
            }
        });

        dishList.forEach(dish -> System.out.println(dish));
        System.out.println("================================");
        dishList.forEach(System.out::println);
        System.out.println("================================");
        // 메뉴 목록중에 육류이면서 600칼로리 미만인 요리를 필터링해서 출력하자
        menuList.stream()
                .filter(d -> d.getCalories() < 600 &&
                        d.getType() == Dish.Type.MEAT)
                .toList()
                .forEach(System.out::println);

        System.out.println("============================");

        menuList.stream()
                .filter(d-> d.getName().length() == 4)
                .toList()
                .forEach(System.out::println);

        System.out.println("==============================");

        menuList.stream()
                .filter(d-> d.getCalories() > 300)
                .limit(3)   // 앞에서 3개만
                .toList()
                .forEach(System.out::println);


        menuList.stream()
                .filter(d-> d.getCalories() > 300)
                .skip(2)    // 맨 앞 2개 제외
                .toList()
                .forEach(System.out::println);

        System.out.println("=================================");

        List<Integer> num = List.of(1, 2, 1, 3, 2, 4, 4, 4, 5, 5, 6, 6, 11, 56, 77);

        num.stream()
                .filter(i -> i % 2 == 0)
                .distinct()   // 중복제거
                .toList()
                .forEach(System.out::println);

    }
}
