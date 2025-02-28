package oop.poly.car;

public class Driver {

    // 매개변수로 Tesla만 받을 수 있음.
    public void drive(Tesla t){
        System.out.println("운전을 시작합니다.");
        t.run();
    }

    // 부모클래스로 선언하면 모든 자식타입을 매개변수로 받을 수 있음.
    public void drive(Car t){
        System.out.println("운전을 시작합니다.");
        t.run();
    }

    public Car buyCar(String name){
        if(name.equals("소나타")){
            System.out.println("소나타를 구매했습니다.");
            return new Sonata();
        }
        else if(name.equals("포르쉐")){
            System.out.println("포르쉐를 구매했습니다.");
            return new Porsche();
        } else if (name.equals("테슬라")) {
            System.out.println("테슬라" +
                    "를 구매했습니다.");
            return new Tesla();
        }
        else{
            System.out.println("그런 차는 없습니다.");
            return null;
        }
    }
}
