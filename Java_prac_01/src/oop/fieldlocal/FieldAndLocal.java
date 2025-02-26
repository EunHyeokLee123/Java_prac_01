package oop.fieldlocal;

public class FieldAndLocal {
    // 필드 또는 멤버변수
    // 값을 초기화하지 않아도, 각 데이터타입의 기본값으로 할당됨.
    int aaa;

    // 멤버 메소드
    void foo(int ccc){  // 매개변수도 일종의 지역변수
        // 메소드 내의 선언된 변수는 지역변수라고함.
        // 해당 블록 내에서만 유료함. 초기화 필수
        int bbb;  // 이건 필드가 아님
        bbb = 17;
        System.out.println("aaa = " + aaa);
        System.out.println("bbb = " + bbb);
        System.out.println("ccc = " + ccc);
    }

}
