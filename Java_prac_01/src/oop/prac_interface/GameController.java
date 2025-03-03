package oop.prac_interface;

// 인터페이스 : 여러 종류의 게임 컨트롤러가 반드시 구현해야 하는 메소드를 선언

public interface GameController {

    // 인터페이스는 변수를 상수 취급함.
    /* public static final*/ int NUM = 5;

    //  생성자 선언 불가능
    // public GameController() {}

    void moveCharacter(String direction);
    void action();
    void pause();

}
