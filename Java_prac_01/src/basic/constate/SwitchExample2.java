package basic.constate;

import java.util.Scanner;

public class SwitchExample2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요 : ");
        int score = sc.nextInt();
        switch (score/10){
            case 9,10:
                if(score >100){
                    System.out.println("점수를 잘못 입력하셨습니다.");
                    break;
                }
                System.out.println("당신의 학점은 A입니다");
                break;
            case 8:
                System.out.println("당신의 학점은 B입니다");
                break;
            case 7:
                System.out.println("당신의 학점은 C입니다");
                break;
            case 6:
                System.out.println("당신의 학점은 D입니다");
                break;
            default:
                if(score>100 || score < 0){
                    System.out.println("점수를 잘못 입력하셨습니다.");
                    break;
                }
                System.out.println("당신의 학점은 F입니다");
                break;
        }


        sc.close();
    }

    public static class SwitchQuiz {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a1, a2; String s1;
            System.out.println("정수1을 입력하시오. ");
            a1 = sc.nextInt();
            System.out.println("연산자를 입력하시오. ");
            s1 = sc.next();
            System.out.println("정수2를 입력하시오. ");
            a2 = sc.nextInt();
            int result = 0; boolean flag = true;
            switch(s1){
                case "+":
                    result = a1 + a2;
                    break;
                case "-":
                    result = a1 - a2;
                    break;
                case "*":
                    result = a1 * a2;
                    break;
                case "/":
                    if(a2==0){
                        System.out.println("0으로 나눌 수는 없습니다.");
                        flag = false;
                        break;
                    }
                    result = a1/a2;
                default:
                    System.out.println("옳지 않은 연산자를 입력하셨습니다.");
                    flag = false;
                    break;
            }
            if(flag){
                System.out.printf("%d "+s1+" %d = %d 입니다.", a1, a2, result);
            }
            else{
                System.out.printf("%d "+s1+" %d 는 계산할 수 없습니다.", a1, a2);
            }

            sc.close();
        }
    }
}
