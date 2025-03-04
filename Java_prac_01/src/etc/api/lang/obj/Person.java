package etc.api.lang.obj;

import java.util.Objects;

public class Person implements Cloneable{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // toString() : 객체의 정보(필드)를 문자열 형태로 리턴
    // Object가 물려주는 toString은 패키지 + 클래스이름 + 주소값
    // ==> 잘 쓸 일이 없다.
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //equals를 오버라이딩 할 때는 hashCode도 함께 오버라이딩을 진행해 주시는 것이 좋습니다.
    //equals를 재 정의한다는 것은 내가 원하는 방식의 동등 비교를 하겠다는 것이기 때문에
    //hashcode의 값도 그에 맞게 같이 재 정의가 되어야 합니다. (hash 주소를 equals에 맞게 정의)

    // 같은 객체의 속성을 비교해서 동등 객체인지를 논리값으로 리턴하는 메소드
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true; // 주소값이 같은 경우
        if(obj instanceof Person){
            Person p = (Person) obj; // 부모의 값을 자식으로 선언, 타입캐스팅 필요
            if(p.age == this.age && p.name.equals(this.name)) return true;
        }
        return false; // Person타입을 가질 수 없다면 동등 비교를 할 필요가 없음.
    }

    /*@Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    /*@Override
    protected void finalize() throws Throwable {

        // 생성된 객체가 소멸될 때 자동으로 호출되는 메소드 (gc가 실행될 때)
        // garbage collector가 호출되는 순간을 보장할 수 없기 때문에
        // 사용을 권장하지 않음.

        super.finalize();
    }*/

    // 객체 복사 메소드
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
