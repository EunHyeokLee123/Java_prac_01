package CodeStudy;

import java.util.Scanner;

public class No_10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tar = sc.next();
        if(tar.length() % 2 == 0){
            String front = tar.substring(0, tar.length() / 2);
            StringBuilder back = new StringBuilder(
                    tar.substring(tar.length()/2));
            if(front.equals(back.reverse().toString()))
                System.out.println(1);
            else
                System.out.println(0);
        }
        else{
            String front = tar.substring(0,tar.length()/2);
            StringBuilder back = new StringBuilder(
                    tar.substring(tar.length()/2+1));
            if(front.equals(back.reverse().toString()))
                System.out.println(1);
            else
                System.out.println(0);
        }

        sc.close();
    }
}
