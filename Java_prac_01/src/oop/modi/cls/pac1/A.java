package oop.modi.cls.pac1;

// public이 없으면 default (package friendly)
// 같은 패키지 내에서만 접근을 허용함.
class A {
    // class B는 public이라 접근 가능
    B b = new B();
}
