package basic.Array;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayExample_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] foods = {"피자", "파스타", "치킨", "삼겹살"};
        System.out.println("찾고싶은 음식을 입력하세요");
        String tar = sc.next();
        int idx = -1;
        for (int i = 0; i < foods.length; i++) {
             /*
             - 자바에서는 문자열 동등 비교 시 '==' 연산자를
              사용하면 제대로 비교가 되지 않습니다.

             - 문자열 String 타입이 기본 데이터 타입이 아닌
              객체 참조 타입이기 때문입니다.
              객체 참조 타입은 해당 값을 직접 들고 있는 게 아니라
              객체의 주소값을 들고 있기 때문에,
              문자열이 아무리 같더라도 주소가 다르면 false를
              도출합니다.

             - 그러므로 문자열 동등 비교를 진행할 때는
             [비교문자열1.equals(비교문자열2)] 를 사용하여
             진행해야 합니다.
        */
            if(foods[i].equals(tar)){
                idx = i;
            }
        }
        if(idx != -1) {
            System.out.printf(tar + "은 %d번째인덱스에 있습니다. \n", idx);
        }
        else{
            System.out.println(tar+"은 배열에 없습니다.");
        }




        // System.out.println(Arrays.toString(foods));
        sc.close();
    }
}
