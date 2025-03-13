package string;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tar = sc.nextLine();
        HashSet<Character> re = new LinkedHashSet<>();
        for (int i = 0; i < tar.length(); i++) {
            re.add(tar.charAt(i));
        }
        for (Character c : re) {
            System.out.print(c);
        }


        sc.close();
    }
}
