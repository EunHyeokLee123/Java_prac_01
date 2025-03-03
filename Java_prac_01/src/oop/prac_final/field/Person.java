package oop.prac_final.field;

public class Person {

    // 초기화되지 않은 변수는 final 불가능
    final String name;
    final String nation;
    int age;

    // 생성 시 name 초기화가 필수로 일어나서
    // name에 final을 붙일 수 있다.
    Person(String name, String nation){
        this.name = name;
        this.nation = nation;
    }

}
