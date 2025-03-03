package oop.prac_interface;

// 인터페이스간의 다중 상속이 가능

public interface AdvancedController extends GameController, Vibration{

    void specialAction();
    void customizeButton(String config);
}
