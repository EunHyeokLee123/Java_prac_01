package basic.LoopTest;

import java.util.Scanner;

/*
         # 무한 루프

         - 무한 루프는 반복 횟수를 정하지 않고 무한하게 반복문을
          실행하는 구조입니다.

         - 처음 반복문을 구성할 때, 개발자가 사전에 정확한 반복 횟수를
          파악할 수 없다면, 무한루프를 일단 구성해 두고
          특정 조건을 통해 종료할 수 있도록 코드를 설계합니다.

         - 일반적으로 정확한 반복 횟수를 알고 있다면 for문을 사용하고,
          정확한 반복 횟수를 모른다면 while을 통한 무한 루프를 형성하여
          사용합니다. while(true), for(;;)
         */

public class InfiniteLoop_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tar = 34;
        while(true){
            System.out.println("1~100 숫자 중 하나를 입력하시오. ");
            int tmp = sc.nextInt();
            if(tmp == tar){
                System.out.println("맞추셨습니다.");
                break;
            }
            else if(tmp > 100){
                System.out.println("1부터 100사이의 숫자를 입력하시오.");
            }
            else{
                System.out.println("틀렸습니다. 다시 입력하세요.");
            }
        }


        sc.close();
    }
}
