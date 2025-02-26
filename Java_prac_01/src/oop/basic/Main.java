package oop.basic;

public class Main {
    public static void main(String[] args) {
        // 설계한 객체를 생성
        // 객체를 생성하면 객체의 주소가 생김
        Pen redPen = new Pen();
        // 참조연산자 .을 통해 객체의 속성, 기능에 접근
        // 객체의 멤버변수 초기화
        redPen.price = 500;
        redPen.Color = "Red";
        redPen.No = "n3000";

        Pen bluePen = new Pen();
        bluePen.price = 1000;
        bluePen.Color = "Blue";
        bluePen.No = "n4000";

        System.out.println("redPen = " + redPen);
        System.out.println("bluePen = " + bluePen);

        redPen.priceInfo(); redPen.write(); redPen.noInfo();
        bluePen.priceInfo(); bluePen.write(); bluePen.noInfo();
    }
}
