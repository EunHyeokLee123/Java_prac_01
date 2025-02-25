package basic.LoopTest;

import java.util.Scanner;

public class ContinueExample_01 {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            System.out.print(i+" ");
            if(i==5){
                // for문에서 continue는 증감식이 발동됨.
                System.out.println();
                continue;
            }
        }
        System.out.println("\n 반복종료");
        System.out.println("======================");
        int i=1;
        while(i<11){
            // while문에서 continue는 증감식이 발동하지 않음.
            if(i==5) continue;
            System.out.printf(i+" ");
            i++;
        }
    }
}
