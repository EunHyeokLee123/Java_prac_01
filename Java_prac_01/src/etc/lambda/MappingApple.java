package etc.lambda;

import java.util.ArrayList;
import java.util.List;

public class MappingApple {

    // 사과의 색상만 추출
    public static List<Color> mappingAppleByColor(List<Apple> apples){
        List<Color> result = new ArrayList<>();
        for (Apple apple : apples) {
            result.add(apple.getColor());
        }
        return result;
    }

    // 어떤 타입의 리스트를 받아도 맵핑이 가능한 전역 메소드를 선언해보자
    public static <T, Y> List<Y> map(List<T> list,
                                     GenericFunction<T, Y> mapper){
        List<Y> result = new ArrayList<>();
        for (T t : list) {
            // T에서 뭔가를 추출하는 행위 -> 행위를 파라미터화하자
            result.add(mapper.apply(t));
        }
        return result;
    }
}
