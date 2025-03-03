package oop.prac_final.method;

public class Child extends Parent{

    @Override
    void method1() {
        super.method1();
    }

    @Override
    void method2() {
        super.method2();
    }

    // Parent의 method3는 final 메소드라서 재정의가 불가능하다.
    /*@Override
    void method3(){
        super.method3();
    }*/
}
