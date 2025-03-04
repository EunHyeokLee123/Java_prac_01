package etc.exception.basic;

import java.util.Scanner;

public class TryCatchExample_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수하나 입력: ");
        int i1 = sc.nextInt();
        System.out.println("정수둘 입력: ");
        int i2 = sc.nextInt();


        try {
            // 예외 발생가능성이 있는 코드를 배치
            System.out.printf("%d / %d = %d \n", i1, i2, i1 / i2);
        } catch (Exception e) {
            // 예외 발생 시 실행할 코드를 배치
            System.out.println("0으로 나눌 수 없습니다.");
            e.printStackTrace();
        }


        sc.close();
    }
}
