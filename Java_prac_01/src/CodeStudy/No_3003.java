package CodeStudy;

import java.util.Scanner;

public class No_3003 {
    static int[] right = {1,1,2,2,2,8};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[right.length];
        for (int i = 0; i < right.length; i++) {
            arr[i] = right[i] - sc.nextInt();
        }
        System.out.printf("%d %d %d %d %d %d",
                arr[0], arr[1], arr[2], arr[3],
                arr[4], arr[5]);
        sc.close();
    }
}
