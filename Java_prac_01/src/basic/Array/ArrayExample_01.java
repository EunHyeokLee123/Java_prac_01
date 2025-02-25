package basic.Array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample_01 {
    public static void main(String[] args) {
        // int[] arr; // int arr[] 도 가능은 하지만 비추천
        // 배열 선언
        int[] arr = new int[6];
        // 배열 초기화, index를 지정해서 데이터를 할당
        // index는 0부터 시작
        arr[0] = 7;
        arr[1] = 8;
        arr[2] = 88;
        arr[3] = 66;
        arr[4] = 546;
        arr[5] = 8888;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr의 ["+i+"]의 숫자는 "+arr[i]);
        }
        for(int idx : arr){
            System.out.print(idx+" ");
        }
        System.out.println();
        // 배열 내부를 문자열형태로 출력하는 방법
        // 외부 class 사용
        System.out.println(Arrays.toString(arr));
        // 배열 선언 및 초기화 한번에 하는 방법
        int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(arr2));
        System.out.println("===================");

        byte[] arr3 = new byte[3];
        double[] arr4 = new double[6];
        boolean[] arr5 = new boolean[4];
        String[] arr6 = new String[5];
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));
        System.out.println(Arrays.toString(arr6));

    }
}
