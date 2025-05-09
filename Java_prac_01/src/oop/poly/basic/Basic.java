package oop.poly.basic;

/*
- 자바에서는 하나의 클래스 파일에 여러 개의 클래스를 선언할 수 있습니다.
 밀접한 연관이 있는 클래스를 모아 놓기 위해 사용합니다.
- 단, 파일명과 동일한 클래스가 반드시 존재해야 하고,
 해당 클래스만 public으로 선언할 수 있습니다.
*/

/*
          Object
            |
            A
         /    \
        B     C
        |     |
        D     E
 */

class A {}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends C {}

public class Basic {
    void method1(){
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();

        A v1 = new B();
        A v2 = new C();
        A v3 = new D();
        A v4 = new E();

        B v5 = new D();
        C v6 = new E();

    }

}
