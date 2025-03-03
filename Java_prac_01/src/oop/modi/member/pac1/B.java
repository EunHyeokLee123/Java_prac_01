package oop.modi.member.pac1;

public class B {

    void test(){
        // public이라 가능
        A a1 = new A(1);

        // default라 같은 패키지기에 가능
        A a2 = new A(1.9);

        // 같은 class가 아닌데 private이라서 불가능함.
        // A a3 = new A(true);

        // public, default라 가능
        a1.f1 = 3;
        a1.f2 = 5;

        // f3는 private이라 접근 불가능
        // a1.f3 = 5;

        // 메소드도 멤버변수와 동일
        a1.m1();
        a1.m2();

        // private이라 접근 불가능
        // a1.m3();

        // 단 메소드가 멤버변수에 접근하는 것은 가능함.
        a1.test();

    }

}
