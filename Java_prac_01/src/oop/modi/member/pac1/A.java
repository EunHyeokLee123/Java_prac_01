package oop.modi.member.pac1;

public class A {

    // 필드
    public int f1;

    int f2;

    private int f3;

    // 생성자
    public A(int a){}
    A(double d){}
    private A(boolean b){}

    // 메소드
    public void m1(){}
    void m2(){}
    private  void m3(){}

    void test(){
       // 같은 클래스 내에서는 모두 접근 가능
        f1=10;
        f2=20;
        f3=30;
        this.m1();
        this.m2();
        this.m3();
    }
}
