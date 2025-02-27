package oop.encap.good;

public class Main {
    public static void main(String[] args) {
        MyBirth my1 = new MyBirth(2000, 11, 28);
        // my1.year  ==> private이라 직접 접근 불가능.
        MyBirth my2 = new MyBirth();
        System.out.println("my1의 생일 정보는 "+my1.getYear()+"년 "
                + my1.getMonth()+"월 "+ my1.getDay()+"일입니다.");
        my2.setYear(1995); my2.setMonth(4); my2.setDay(15);
        my2.birthInfo();
        System.out.println("============================");
        MyBirth my3 = new MyBirth();
        my3.setYear(2010);
        my3.setMonth(2);
        my3.setDay(29);
        my3.birthInfo();
    }
}
