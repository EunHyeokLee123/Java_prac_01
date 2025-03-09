package CodeStudy;

import java.util.Scanner;

public class No_3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] arr = new boolean[42];
        for (int i = 0; i < 10; i++) {
            int tmp = sc.nextInt()%42;
            arr[tmp] = true;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i])
                count++;
        }
        System.out.println(count);
        sc.close();
    }
}
