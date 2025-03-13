package string;

import java.util.Scanner;

public class solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String tar = sc.nextLine();
        input = input.toLowerCase();
        char target = tar.toLowerCase().charAt(0);
        int count = 0;
        for (char c : input.toCharArray()) {
            if(c == target)
                count++;
        }

        System.out.println(count);


        sc.close();
    }
}
