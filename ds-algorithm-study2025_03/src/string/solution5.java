package string;

import java.util.Scanner;

public class solution5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        // 알파벳만 추출할 문자열을 받을 변수
        String t2 = "";
        for (int i = 0; i < str.length(); i++) {
            if(Character.isAlphabetic(str.charAt(i)))
                t2 += str.charAt(i);
        }
        t2 = t2.toLowerCase();
        // reverse 사용을 위해 Stringbuilder 객체 선언
        StringBuilder sb2 = new StringBuilder(t2);
        StringBuilder reverse = sb2.reverse();

        if(t2.contentEquals(reverse))
            System.out.println("YES");
        else
            System.out.println("NO");


        sc.close();
    }
}
