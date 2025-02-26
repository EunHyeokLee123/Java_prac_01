package basic.Array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 하나 입력하시오. ");
        int tar = sc.nextInt();
        int count = 0;
        int[] arr = new int[tar];
        for (int i = 2; i < tar; i++) {
            boolean tmp = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    tmp = false;
                }
            }
            if(tmp){
                arr[count] = i;
                count++;
            }
        }
        System.out.printf("입력받은 수 -> %d \n", tar);
        System.out.printf("소수 : ");
        for(int k=0;k<count;k++){
            System.out.printf("%d ", arr[k]);
        }
        System.out.println();
        System.out.printf("소수의 개수: %d개 \n", count);
        sc.close();

    }
}
