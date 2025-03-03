package oop.pracStatic_.method;

import oop.modi.cls.pac2.C;

public class Count {
    public int a;  // 각 객체별 생성됨
    public static int b;    // 모든 객체가 값을 공유하게 됨.

    public int method1(){
        return this.a + Count.b;
    }

     /*
        - static 블록(메서드, 정적 초기화자) 내부에서는
        static이 붙은 변수나 메서드만 사용할 수 있습니다.
        - this는 사용할 수 없습니다. -> 나타낼 주소값이 없기 때문 -> 객체 생성 없이도 호출이 가능하기 때문.

        - static 블록 내부에서 non-static 멤버를 참조하려면
         반드시 객체를 생성해서 주소값을 통해 참조해야 합니다.
     */

    // static은 객체에서 호출이 아닌 클래스에서 호출되기에
    // 메소드 내부에서 this를 사용하지 못한다.
    public static int method2(){
        return Count.b;
    }
}
