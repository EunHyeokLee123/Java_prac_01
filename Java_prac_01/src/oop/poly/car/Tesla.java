package oop.poly.car;

public class Tesla extends Car{

    @Override
    public void run() {
        System.out.println("테슬라 달린다!");
    }

    public void activeAutoPilot(){
        System.out.println("자율주행 시작합니다.");
    }
}
