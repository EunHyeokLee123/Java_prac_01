package etc.stream;

import java.util.Comparator;

import static etc.stream.Menu.*;

public class Sorting {
    public static void main(String[] args) {

        // 육류 요리 증 칼로리가 낮은 순으로 정렬
        menuList.stream()
                .filter(d->d.getType() == Dish.Type.MEAT)
                // 오름차순으로 정렬
                .sorted(Comparator.comparing(Dish::getCalories))
                .toList()
                .forEach(System.out::println);

        System.out.println("=============================");

        // 육류 요리 증 칼로리가 높은 순으로 정렬
        menuList.stream()
                .filter(d->d.getType() == Dish.Type.MEAT)
                // default는 오름차순으로 정렬
                .sorted(Comparator.comparing(Dish::getCalories).reversed())
                .toList()
                .forEach(System.out::println);

        System.out.println("=================================");

        // 모든 메뉴들을 이름으로 내림차순 정렬 (zxy순)
        menuList.stream()
                .sorted(Comparator.comparing(Dish::getName).reversed())
                .toList()
                .forEach(System.out::println);

        System.out.println("=================================");

        // 칼로리가 300칼로리보다 큰 요리중
        // 칼로리 낮은 순으로 앞에서 3개만 필터링
        menuList.stream()
                .filter(dish -> dish.getCalories() > 300)
                .sorted(Comparator.comparing(Dish::getCalories))
                .limit(3)
                .toList()
                .forEach(System.out::println);

    }
}
