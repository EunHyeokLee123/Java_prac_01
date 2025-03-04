package etc.api.lang.obj;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("홍길동", 68);
        Person p2 = new Person("김민식", 36);
        Person p3 = new Person("김민식", 36);

        System.out.println(p1);
        System.out.println(p1.toString());

        System.out.println(p1.equals(p2));
        // 주소값이 같은지
        System.out.println(p2 == p3);
        // 변수의 정보(필드)가 같은지
        System.out.println(p3.equals(p2));

        System.out.println(p1.hashCode());

        // eqauls에서 동등한 객체라고 판명이 되었다면, 서로 다른 객체더라도
        // 객체의 고유한 주소를 동일하게 처리해서 서로 같은 객체임을 명확히 해야함.
        // 그래야, 자바에서 기본으로 제공하는 클래스 중에 hash를 비교해서 동등 객체인지 아닌지를
        // 판별하는 자료구조(HashSet, HashMap)들이 정상적으로 동작할 수 있습니다.
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());

        Person p4 = new Person("황목치승", 38);
        Person p5 = new Person("김목경", 44);
        try {
            // clone의 리턴타입이 Object라서 Person으로 타입캐스팅 필요
            p5 = (Person) p4.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        HashSet<Person> person = new HashSet<>();
        person.add(p1);
        person.add(p2);
        person.add(p3);
        person.add(p4);
        person.add(p5);

        // p2와 p3는 동일한 hash값을 가져서 중복이라서 하나만 들어감.
        System.out.println(person);
    }
}
