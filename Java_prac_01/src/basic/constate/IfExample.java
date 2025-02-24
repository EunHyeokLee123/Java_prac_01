package basic.constate;

import java.util.Scanner;

public class IfExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("점수를 입력하세요 : ");
        int score = sc.nextInt();
        System.out.printf("점수는 = %d 이군요.\n", score);
        if(score >=60){
            System.out.print("합격하셨습니다! \n");
        }
        else{
            System.out.print("불합격입니다.\n");
        }
        System.out.println("시험 치르느라 고생하셨습니다.");




        sc.close();
    }
}
