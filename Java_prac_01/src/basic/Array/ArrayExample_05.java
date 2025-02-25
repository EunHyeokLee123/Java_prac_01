package basic.Array;

import java.util.Scanner;
import java.util.Arrays;

// Array Pop 배열의 맨 끝 데이터를 삭제하면서 빼내옴.

public class ArrayExample_05 {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70,80,90,100};
        System.out.println(Arrays.toString(arr));
        // 원본 마지막 아아템을 제외한 모든 아이템을 임시 배열에 복사
        int[] tmp = new int[arr.length-1];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = arr[i];
        }
        // pop될 마지막 아이템을 변수에 저장
        int pop_re = arr[arr.length-1];
        // 임시 배열 삭제 및 주소값 이동
        arr = tmp; tmp = null;
        System.out.println(Arrays.toString(arr));
        System.out.printf("pop된 아이템은 %d이다. \n", pop_re);
    }
}
