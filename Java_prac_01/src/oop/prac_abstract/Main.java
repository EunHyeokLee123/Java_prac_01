package oop.prac_abstract;

public class Main {
    public static void main(String[] args) {

        // 추상 클래스의 객체는 직접 생성 불가
        // Shape s1 = new Shape("하양");

         /*
         - 추상 클래스(추상 메서드)를 사용하면 오버라이딩이 강제화 되기 때문에
          프로그래머의 오버라이딩 실수를 방지할 수 있고, 부모 클래스에서
          메서드를 선언할 때 메서드 내부에 어떤 내용을 써야 할 지 막연할 때도
          구현하기가 편합니다.

         - 다형성을 적용시켰을 경우에도 안전하게 사용이 가능합니다.
         */

        // 자식클래스를 통해 추상클래스 객체 생성은 가능
        Shape c1 = new Circle(5.0, "빨강");
        Circle c2 = new Circle(8.0, "파랑");

        Shape t1 = new Triangle("검정", 3, 4, 5);
        Triangle t2 = new Triangle("갈색", 6, 8, 10);

        Shape[] sh = {c1,c2,t1, t2};

        for (Shape s1 : sh) {
            s1.displayInfo();
        }

    }
}
