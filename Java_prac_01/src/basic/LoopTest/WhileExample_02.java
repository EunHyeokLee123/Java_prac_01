package basic.LoopTest;

import java.util.Arrays;
import java.util.Scanner;

public class WhileExample_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*int i=48;
        while(i<=150){
            if(i%8==0){
                System.out.print(i+" ");
            }
            i++;
        }
        System.out.println();
        int k=1;
        while(k<101){
            if(k%4==0){
                if(k%8!=0){
                    System.out.print(k+" ");
                }
            }
            k++;
        }*/
        System.out.println();
        int ab = 1; int count = 0;
        while(ab<=30000){
            if(ab%258==0){
                count++;
            }
                ab++;
        }
        System.out.printf("258의 배수의 개수는 %d개입니다.", count);

        System.out.println();
        int a1 = 1; int c1 = 0;
        while(a1<=1000){
            if(1000%a1==0){
                c1++;
            }
            a1++;
        }
        System.out.printf("1000의 약수의 개수는 %d개입니다.", c1);
        System.out.println();
        /*for(int j=48;j<151;j++){
            if(j%8==0){
                System.out.print(j+" ");
            }
        }*/
    }
}
