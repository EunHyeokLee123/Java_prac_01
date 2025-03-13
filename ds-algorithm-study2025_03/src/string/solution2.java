package string;

import java.util.Arrays;
import java.util.Scanner;

public class solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        StringBuilder[] str = new StringBuilder[count];
        for (int i = 0; i < count; i++) {
            String tmp = sc.nextLine();
            str[i] = new StringBuilder(tmp);
        }

        for (StringBuilder stringBuilder : str) {
            System.out.println(stringBuilder.reverse());
        }


        sc.close();
    }
}
