package basic.constate;

import java.util.Scanner;

public class IfExample2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.printf("나이를 입력하세요. ");
        int age = sc.nextInt();

        if(age >=20){
            System.out.println("성인입니다!");
            if (age >= 40){
                System.out.println("불혹의 나이시군요");
            }
            else if(age>=65){
                System.out.println("국민연금을 받을 나이시군요");
            }
        }
        else if(age >= 17){
            System.out.println("고등학생이구나!");
        } else if (age >=14) {
            System.out.println("중학생이구나!");
        } else if (age >=8) {
            System.out.println("초등학생이구나!");
        }
        else {
            System.out.println("미취학아동이구나!");
        }


        sc.close();
    }
}
