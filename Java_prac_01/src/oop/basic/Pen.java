package oop.basic;

public class Pen {
    // 객체 속성을 표현 --> 필드, 멤버변수라고 부름.
    int price;  // 가격
    String Color;  // 색상
    String No;  // 일련번호

    Pen(){

    }

    Pen(String col, String no, int pri){
        Color = col;
        No = no;
        price = pri;
    }

    // 객체의 기능을 표현한 함수를 메소드라고 부름.
    void write(){
        System.out.println(Color + "색 글을 씁니다.");
    }
    void priceInfo(){
        System.out.println(Color+"색 펜의 가격은 "+ price +" 원입니다.");
    }
    void noInfo(){
        System.out.println(Color+"색 펜의 일련번호는 "+No+" 입니다.");
    }
}