package CodeStudy;

import java.util.Scanner;

public class No_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int max = 0; int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = sc.nextInt();
            if(tmp > max){
                max = tmp;
                idx = i;
            }
        }
        System.out.println(max);
        System.out.println(idx+1);

        sc.close();
    }
}
