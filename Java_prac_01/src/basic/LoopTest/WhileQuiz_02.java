package basic.LoopTest;

import java.util.Scanner;

public class WhileQuiz_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1, a2;
        System.out.println("정수 1을 입력하시오.");
        a1 = sc.nextInt();
        System.out.println("정수 2를 입력하시오.");
        a2 = sc.nextInt();
        /*if(a1>a2){
            int tmp = a2;
            a2 = a1;
            a1 = tmp;
        }*/
        int start = a1 > a2 ? a2 : a1;
        int end = a2 > a1 ? a2: a1;
        int idx = a1; int result = 0;
        while(idx <= a2){
            result += idx;
            idx++;
        }
        System.out.printf("%d부터 %d까지의 누적 합계는 %d입니다. \n", a1, a2, result);



        sc.close();
    }
}
