package oop.pracStatic_.singleton;

/*
     # 싱글톤 디자인 패턴: 클래스의 객체를 단 1개로 제한하기 위한 디자인 패턴.
     무분별한 객체의 생성을 막고, 하나의 객체를 여러 번 재활용하기 위한 목적.

     1. 외부에서 이 클래스의 객체를 생성하지 못하도록 생성자를 단 1개만
      선언하고, private 접근 제한을 붙임.
     */

public class Singleton {

    // 생성자를 접근못하게 private으로
    private Singleton(){
        System.out.println("Singleton 객체 생성");
    }

    //  클래스 내부에 객체를 생성
    private static Singleton s = new Singleton();

    // 객체에 접근을 메소드로만 가능하게끔
    public static Singleton getInstance(){
        return s;
    }

    public void method1(){
        System.out.println("여러 클래스에서 사용하는 중요한 메소드");
    }

    public void method2(){
        System.out.println("프로그램 내에서 한번씩은 " +
                "호출해야 하는 필수 메소드!");
    }
}
