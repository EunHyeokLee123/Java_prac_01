package basic.LoopTest;

import java.util.Scanner;

public class Whilequiz_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 하나 입력하세요. ");
        int tar = sc.nextInt();
        boolean result = true;
        for(int i = 2; i < tar; i++){
            if(tar % i == 0){
                result = false;
            }
        }
        if(result){
            System.out.printf("%d는 소수입니다.", tar);
        }
        else {
            System.out.printf("%d는 소수가 아닙니다.", tar);
        }



        sc.close();
    }
}
