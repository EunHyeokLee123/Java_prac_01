package oop.prac_interface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 일반적인 클래스 선언
        KeyBoardController key = new KeyBoardController();
        JoystickController joy = new JoystickController();
        TouchScreenController touch = new TouchScreenController();

        // 인터페이스와 구현체간에도 다형성이 존재
        // 아래와 같이 선언도 가능
        GameController k1 = new KeyBoardController();
        GameController j1 = new JoystickController();
        GameController t1 = new TouchScreenController();

        System.out.println("너가 게임을 플레이할 도구를 선책해.");
        System.out.println("1. 키보드 | 2. 조이스틱 | 3. 터치스크린 | " +
                "4. 듀얼스틱");
        Scanner sc = new Scanner(System.in);
        int menu = sc.nextInt();

        GameController gc;

        switch (menu){
            case 1:
                gc = new KeyBoardController();
                gc.action(); gc.moveCharacter("동쪽");
                gc.pause();
                break;
            case 2:
                gc = new JoystickController();
                gc.action(); gc.moveCharacter("동쪽");
                gc.pause();
                JoystickController jo = new JoystickController();
                jo.vibrate(66); jo.offVibrate();
                break;
            case 3:
                gc = new TouchScreenController();
                gc.action(); gc.moveCharacter("동쪽");
                gc.pause();
                break;
            case 4:
                DualStick d1 = new DualStick();
                d1.customizeButton("패링"); d1.action();
                d1.offVibrate(); d1.vibrate(55);
                d1.moveCharacter("남쪽"); d1.specialAction();
                d1.pause(); break;
            default:
                System.out.println("해당 컨트롤러는 없습니다.");
        }


        sc.close();


    }
}
