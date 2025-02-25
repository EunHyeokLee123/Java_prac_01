package basic.LoopTest;

import java.util.Scanner;


public class WhileQuiz_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1, a2, a3;
        System.out.println("정수 입력 : ");
        a1= sc.nextInt();
        System.out.println("정수 입력 : ");
        a2= sc.nextInt();
        System.out.println("정수 입력 : ");
        a3= sc.nextInt();
        int mid, low, high;
        if(a1>a2){
            if(a1>a3){
                if(a2>a3){
                    high = a1;
                    mid = a2;
                    low = a3;
                }
                else{
                    high = a1;
                    mid = a3;
                    low = a2;
                }
            }
            else{
                high = a3;
                mid = a1;
                low = a2;
            }
        }
        else{
            if(a2>a3){
                high = a2;
                if(a1>a3){
                    mid = a1;
                    low = a3;
                }
                else{
                    mid = a3;
                    low = a1;
                }
            }
            else{
                high = a3;
                mid = a2;
                low = a1;
            }
        }
        System.out.printf("크기 순서대로 %d, %d, %d이다.\n", high, mid, low);
    sc.close();
    }
}
