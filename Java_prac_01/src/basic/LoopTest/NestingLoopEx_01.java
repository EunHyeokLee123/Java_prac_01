package basic.LoopTest;

import java.util.Scanner;

/*
         # 반복문 중첩 (loop nesting)

         - 외부 반복문 내부에 내부 반복문이 존재하는 형태를
         반복문 중첩이라고 합니다.
         반복문 자체를 반복시켜야 할 경우에 중첩을 사용합니다.

         - 내부 반복문이 종료가 되어도, 외부 반복문이 끝나지 않는다면
          내부 반복문은 외부 반복문의 제어변수의 크기 및 범위까지
          계속해서 반복 실행되게 됩니다.
         */

public class NestingLoopEx_01 {
    public static void main(String[] args) {

        for (int i = 2; i < 10; i++) {
            System.out.printf("*** 구구단 "+ i + "단 *** \n");
            System.out.println();
            for (int j = 1; j < 10; j++) {
                System.out.printf("%d X %d = %d \n", i, j, i*j);
            }
        }
    }
}
