package basic.LoopTest;

import java.util.Scanner;

/*

 *
 **
 ***
 ****
 *****

 */



public class NestingLoopEx_02 {
    public static void main(String[] args) {
        /*for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }*/
        for (int i = 1; i < 6; i++) {
            for (int j = 5 - i; j > 0 ; j--) {
                System.out.printf(" ");
            }
            for (int k = 5 - i; k < 5; k++) {
                System.out.printf("*");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 1; i < 6; i++) {
            for (int j = 4; j >=i ; j--) {
                System.out.printf(" ");
            }
            for (int k = 1; k <= i ; k++) {
                System.out.printf("*");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < i; j++) {
                System.out.printf(" ");
            }
            for (int k = 0; k < 6 - i ; k++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
