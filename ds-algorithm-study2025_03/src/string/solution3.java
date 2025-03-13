package string;

import java.util.Scanner;

public class solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tar = sc.next();
        char[] result = new char[tar.length()];
        for (int i = 0; i < tar.length(); i++) {
            if(Character.isAlphabetic(tar.charAt(i))){
                result[tar.length() -i - 1] = tar.charAt(i);
            }
            else{
                result[i] = tar.charAt(i);
            }
        }
        System.out.println(new String(result));

        sc.close();
    }
}
