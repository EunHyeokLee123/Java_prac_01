package oop.poly.car;

public class Main {
    public static void main(String[] args) {

        Sonata s1 = new Sonata();
        Sonata s2 = new Sonata();
        Sonata s3 = new Sonata();

        Porsche p1 = new Porsche();
        Porsche p2 = new Porsche();
        Porsche p3 = new Porsche();

        Tesla t1 = new Tesla();
        Tesla t2 = new Tesla();
        Tesla t3 = new Tesla();
        Car t4 = new Tesla();

/*
        s1.run(); p1.run(); t1.run();
        s2.run(); p2.run(); t2.run();
        s3.run(); p3.run(); t3.run(); t4.run();
*/
        Sonata[] son = {s1, s2, s3};
        Porsche[] por = {p1, p2, p3};
        Tesla[] tes = {t1, t2, t3};

        for (Sonata sonata : son) {
            sonata.run();
        }
        for (Porsche porsche : por) {
            porsche.run();
        }
        for (Tesla te : tes) {
            te.run();
        }

        // 부모 타입의 배열에 자식 타입 객체가 들어갈 수 있다.
        // 이종 모음의 배열
        Car[] car = {s1, s2, s3, p1, p2, p3,
        t1, t2, t3, t4};

        for (Car c : car) {
            // Car의 run메소드가 아닌
            // 자식 클래스의 오버라이드된 메소드가 호출됨.
            c.run();
        }

        System.out.println("=========================");
        Driver kim = new Driver();
        kim.drive(s1);
        kim.drive(t1);
        kim.drive(p1);

        t1.activeAutoPilot();
        //  Car로 선언된 t4는 Tesla의 고유 메소드 사용 불가
        //  t4.activeAutoPilot();

        Car kimCar = kim.buyCar("테슬라");
        kimCar.run();

         /*
         - 다형성이 적용되면 자식 클래스의
          본래의 멤버(필드, 메서드)를 참조하지 못하는 문제가 발생합니다.
          (부모의 정보로 자식객체에 접근하면 자식이 확장한 개념에 대한 정보를 알 방법이 없다.)

         - 이를 해결하기 위해 강제 타입 변환을 사용합니다.
         */

        // 부모 타입을 자식타입으로 넣는건 불가능
        // Tesla t5 = kimCar;
        // 타입 캐스팅을 해야한다.
        Tesla kimcarRe = (Tesla) kimCar;
        // 자식 클래스의 메소드는 사용 불가능
        //   kimcarRe.activeAutoPilot();
        //  Car로 선언되어서 Tesla의 고유 메소드 사용 불가

        // 메소드 호출과 동시에 타입캐스팅도 가능
        Tesla kimCar3 = (Tesla) kim.buyCar("테슬라");
        kimCar3.run();
        // 자식 클래스의 메소드는 사용 불가능
        //    kimCar3.activeAutoPilot();

        System.out.println("=======================");

        CarShop shop = new CarShop();
        shop.carPrice(p1);
        shop.carPrice(s1);
        shop.carPrice(t1);

    }
}
