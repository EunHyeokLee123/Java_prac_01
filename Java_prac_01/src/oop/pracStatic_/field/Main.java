package oop.pracStatic_.field;

public class Main {
    public static void main(String[] args) {
        Count c1 = new Count();
        c1.a += 5; c1.b +=5;
        System.out.println("c1.a = " + c1.a);
        System.out.println("c1.b = " + c1.b);

        System.out.println("===============");
        Count c2 = new Count();
        c2.a += 8; c2.b +=8;
        System.out.println("c2.a = " + c2.a);
        System.out.println("c2.b = " + c2.b);

        System.out.println("===============");
        Count c3 = new Count();
        c3.a += 15; c3.b +=15;
        System.out.println("c3.a = " + c3.a);
        System.out.println("c3.b = " + c3.b);
        System.out.println("c1.b = " + c1.b);
        System.out.println("c2.b = " + c2.b);

        // static 변수는 주소값이 아닌 클래스명으로 참조한다.
        Count.b +=7;
    }
}
