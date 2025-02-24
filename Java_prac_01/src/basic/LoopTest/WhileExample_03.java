package basic.LoopTest;

import java.util.Scanner;

/*
             # 사용자에게 구구단 단수를 입력받아서
             해당 단수의 구구단을 출력해 보세요.
             ex)

             구구단을 입력하세요: 4
             *** 구구단 4 단 ***
             4 x 1 = 4
             4 x 2 = 8
             4 x 3 = 12
             4 x 4 = 16
             .
             .
             .
             4 x 9 = 36
         */

public class WhileExample_03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("구구단을 입력하세요: ");
        int a1 = sc.nextInt();
        int i=1;
        System.out.printf("*** 구구단 %d 단 ***", a1);
        System.out.println();
        while(i<10){
            int tmp = i*a1;
            System.out.printf("%d X %d = %d", a1, i, tmp);
            System.out.println();
            i++;
        }
    }
}
