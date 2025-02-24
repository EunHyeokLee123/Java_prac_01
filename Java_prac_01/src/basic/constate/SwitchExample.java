package basic.constate;

import java.util.Scanner;

public class SwitchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("성별을 입력하시오(M/F) : ");
        String gender = sc.next();

        switch (gender){
            // case "M" : case "m" :
            case "M", "m" :
                System.out.println("남성이시군요.");
                break;
            case "F", "f" :
                System.out.println("여성이시군요.");
                break;
            default:
                System.out.println("잘못 입력하셨습니다.");
        }
        sc.close();
    }
}
