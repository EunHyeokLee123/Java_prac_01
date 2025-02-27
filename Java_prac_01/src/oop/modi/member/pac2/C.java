package oop.modi.member.pac2;

import oop.modi.member.pac1.A;

// class A와 다른 패키지

public class C {
    // public이라 가능
    A a6 = new A(5);


    // default인데 다른 패키지기에 불가능
    // A a2 = new A(1.9);
    // 같은 class도 아니고 다른 패키지라서
    // private이라서 불가능함.
    // A a3 = new A(true);

    // public이라 가능
    // a5.f1 = 4;

    // default라 불가능
     // a.f2 = 5;

    // f3는 private이라 접근 불가능
    // a.f3 = 5;

    // 메소드도 멤버변수와 동일
    // a5.m1();
        
        // default라 불가능
     //   a.m2();

    // private이라 접근 불가능
    // a.m3();

    // 단 메소드가 멤버변수에 접근하는 것은 가능함.
    // a.test();
}
