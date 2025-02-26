package basic.LoopTest;

import java.util.Scanner;

public class InfiniteLoopQuiz_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cor = 0; int wro = 0;
        Dae : while(true){
            int num1 = (int) (Math.random()*100 + 1);
            int num2 = (int) (Math.random()*100 + 1);
            int oper = (int) (Math.random()*3);
            int result = 0; int ans;
            switch (oper){
                case 0:
                    result = num1 / num2;
                    System.out.printf("%d / %d = ?\n", num1, num2);
                    break;
                case 1:
                    result = num1+num2;
                    System.out.printf("%d + %d = ?\n", num1, num2);
                    break;
                case 2:
                    result = num1 - num2;
                    System.out.printf("%d - %d = ?\n", num1, num2);
                    break;
                case 3:
                    result = num1 * num2;
                    System.out.printf("%d * %d = ?\n", num1, num2);
                    break;
            }
            ans = sc.nextInt();
            if(ans == result){
                System.out.println("정답입니다.");
                cor++;
            } else if (ans == 0) {
                System.out.println("종료합니다.");
                System.out.printf("정답 횟수 : %d, 오답 횟수 : %d \n",cor, wro);
                break Dae;
            }
            else{
                System.out.println("오답입니다.");
                wro++;
            }

        }
        sc.close();
    }
}
