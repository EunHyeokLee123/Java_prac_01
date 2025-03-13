package etc.stream;

import java.util.Comparator;

import static etc.stream.Menu.*;

public class Finding {
    public static void main(String[] args) {
        // 메뉴 목록에서 채식주의자가 먹을 수 있는 요리가 하나라도 존재하는가?
        boolean b = menuList.stream()
                .anyMatch(Dish::isVegetarian);

        System.out.println("b = " + b);
        // 메뉴 목록 중 칼로리가 100이하인 요리가 하나라도 존재하는가?
        boolean b1 = menuList.stream()
                // 리스트의 요소 중 해당 조건을 만족하는 요소가 하나라도 존재하는가?
                .anyMatch(d -> d.getCalories() <= 100);
        System.out.println("b1 = " + b1);

        boolean b2 = menuList.stream()
                // 리스트의 요소가 해당 조건을 모두 만족하는지?
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println("b2 = " + b2);

        // 음식 메뉴 중 모든 요리가 1000칼로리 미만이 아닙니까?
        boolean b3 = menuList.stream()
                // 리스트의 요소가 해당 조건을 모두 불만족하는가?
                        .noneMatch(d-> d.getCalories() > 1000);
        System.out.println("b3 = " + b3);

        // 음식 중에 칼로리가 가장 높은/ 낮은 음식은 무엇인가요?
        Dish di2 = menuList.stream()
                .min(new Comparator<Dish>() {
                    @Override
                    public int compare(Dish o1, Dish o2) {
                        return o1.getCalories() - o2.getCalories();
                    }
                })
                .get();
        System.out.println("di2 = " + di2);

        Dish di1 = menuList.stream()
                .max(Comparator.
                        comparing(Dish::getCalories))
                .get();
        System.out.println("di1 = " + di1);



    }
}
