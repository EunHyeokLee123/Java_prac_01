package basic.LoopTest;

import java.util.Scanner;

/*
             # while문의 진행 순서.
             1. 제어변수를 선언함. (시작값이 정해짐)
             2. while문의 조건식을 검사해서 true면 반복문이 시작.
              false라면 반복문 종료.
             3. while문 블록 내부가 한 번 진행되면(끝까지 내려가면)
              다시 조건식을 검사하여 true라면 반복문 계속 진행,
              false라면 반복문 종료.
             4. 반복문 내에는 증감식을 배치해서 제어변수의 값을 조정.
         */

public class WhileExample_01 {
    public static void main(String[] args) {
        int i=1;
        int tmp =0;
        while(i<=10){
            tmp +=i;
            System.out.printf("하위X%d \n",tmp);
            i++;
        }
    }
}
