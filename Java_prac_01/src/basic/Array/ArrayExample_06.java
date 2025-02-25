package basic.Array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(num));
        System.out.println("삭제를 원하는 인덱스를 입력 (0 ~ 9)");
        int tar = sc.nextInt();
        int[] tmp = new int[num.length-1];

        num[tar] = 0;
        for (int i = tar; i < num.length - 1 ; i++) {
            int temp = num[i];
            num[i] = num[i+1];
            num[i+1] = temp;
        }
        for (int j = 0; j < tmp.length; j++) {
            tmp[j] = num[j];
        }

        num = tmp; tmp = null;
        System.out.println(Arrays.toString(num));


        sc.close();
    }
}
