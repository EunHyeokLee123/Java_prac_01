package etc.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        /*
             # ArrayList
             - 배열과 다르게 크기가 자동으로 조절되는 자료구조 클래스.
             - 배열과 유사한 형태이기 때문에 순차적으로 데이터에 접근하기가 좋다.
             - 인덱스를 활용하며, 객체의 중복 저장을 허용한다.
         */

        //  <> -> 제네릭 : 타입의 형식을 지정하여 타입 안정성을 꾀하기 위한 문법

        List<Integer> arr1 = new ArrayList<>();
        arr1.add(44); arr1.add(22);
        arr1.add(44);
        arr1.add(3,133);
        arr1.add(1,61);
        int rr = arr1.get(2);
        int len = arr1.size();
        arr1.set(0,7867);
        for (int i = 0; i < arr1.size(); i++) {
            System.out.println(arr1.get(i));
        }
        boolean isAt = arr1.contains(678);
        System.out.println(isAt);

        int dx = arr1.indexOf(44);
        arr1.clear();

        /*
        * 컬렉션 객체들은 Collections의 기능을 사용할 수 있음.
        * Collections는 컬렉션의 부가 기능들을 제공함.
        * */

        // 한번에 객체 많이 추가하기
        Collections.addAll(arr1,4, 5, 88, 99, 1, 123, 456);

        // Collections.frequency(List, target) 타겟이 몇 개 있는지
        System.out.println("99점 학생 수 : " + Collections.frequency(arr1, 99));

        System.out.println("최댓값은 : " + Collections.max(arr1));
        System.out.println("최솟값은 : " + Collections.min(arr1));
        // 오름차 정렬
        Collections.sort(arr1);
        System.out.println(arr1.toString());

        // 내림차 정렬 -> sort 후 reverse
        Collections.reverse(arr1);
        System.out.println(arr1.toString());
        // 한번에 내림차 정렬
        Collections.sort(arr1, Collections.reverseOrder());
        System.out.println(arr1.toString());

        // 두 요소의 위치를 교체 swap(list, index1, index2)
        Collections.swap(arr1, 3, 5);
        System.out.println(arr1.toString());

        // 리스트 내의 요소를 무작위로 섞기
        Collections.shuffle(arr1);
        System.out.println(arr1);

        // 원하는 객체로 컬렉션을 전부 초기화
        Collections.fill(arr1, 4000);
        System.out.println(arr1.toString());


        // asList로 선언한 리스트는 값의 추가, 삭제가 불가능하다.
        // 고정형 리스트가 됨. 값의 수정은 가능함.(고정된 크기를 가짐.)
        List<Integer> rvr = Arrays.asList(1,2,3,4,5,6,7,8,9,10);


        System.out.println("===========================================");

        List<String> str = new ArrayList<>();
        str.add("류현진");
        str.add("엄상백");
        str.add("와이스");str.add("폰세");str.add("문동주");
        str.add("김민우");
        str.add("권민규");

        System.out.println("str = " + str);





    }
}
