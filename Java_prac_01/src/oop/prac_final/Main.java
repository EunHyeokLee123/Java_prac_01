package oop.prac_final;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("류현진", "대한민국");
        // nation이 final이라서 값 변경이 불가능
        // p1.nation = "미국";
        
        // age는 final이 아니라 값 대입 가능
        p1.age = 38;
    }
}
