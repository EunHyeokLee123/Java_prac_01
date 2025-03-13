package string;

import java.util.Scanner;

public class solution5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String tmp = str.replaceAll("[^a-zA-Z0-9 ]","");
        String front; String back;
        if(tmp.length()%2==0){
            front = tmp.substring(0,tmp.length()/2).toLowerCase();
            back = tmp.substring(tmp.length()/2).toLowerCase();
        }
        else{
            front = tmp.substring(0,tmp.length()/2).toLowerCase();
            back = tmp.substring(tmp.length()/2+1).toLowerCase();
        }

        StringBuilder sb2 = new StringBuilder(back);
        StringBuilder reverse = sb2.reverse();
        back = String.valueOf(reverse);

        boolean result = front.equals(back);
        if(result)
            System.out.println("YES");
        else
            System.out.println("NO");


        sc.close();
    }
}
