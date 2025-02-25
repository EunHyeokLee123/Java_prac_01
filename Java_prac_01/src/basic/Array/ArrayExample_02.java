package basic.Array;

import java.util.Arrays;

public class ArrayExample_02 {
    public static void main(String[] args) {
        // push : 배열의 끝에 데이터 추가
        int[] numbers = {10,20,30,40};
        int newNum = 50;

        System.out.println(Arrays.toString(numbers));
        // 1. 기존 배열보다 사이즈가 더 큰 새로운 배열을 선언해서 복사
        int[] num1 = new int[numbers.length + 1];
        // 2, 기존 데이터를 새 배열에 복사
        for (int i = 0; i < numbers.length; i++) {
            num1[i] = numbers[i];
        }
        // 3. 추가할 새로운 데이터를 할당
        num1[numbers.length] = newNum;
        // 4. 주소값 이전 (num1을 사용하지 않기 위해)
        numbers = num1; num1 =null;
        System.out.println(Arrays.toString(numbers));

    }
}
