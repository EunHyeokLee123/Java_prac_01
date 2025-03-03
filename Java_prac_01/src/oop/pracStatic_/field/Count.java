package oop.pracStatic_.field;

public class Count {
    public int a;  // 각 객체별 생성됨

    /*
         - static이 붙은 데이터는 그 static 데이터가 선언된
          클래스의 이름으로 바로 참조할 수 있습니다.
         - 일반 멤버변수(필드)와 혼동할 가능성이 있기 때문에
          주소값으로 접근하지 않습니다.
         */

    public static int b;    // 모든 객체가 값을 공유하게 됨.
}
