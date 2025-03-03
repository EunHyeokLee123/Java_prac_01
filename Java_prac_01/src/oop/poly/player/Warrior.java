package oop.poly.player;

/*
    # 자식 클래스, 하위 클래스 (Child, Sub class)

    - 부모 클래스로부터 멤버변수(필드)와 메서드를 물려받는 클래스를
     자식 클래스라고 합니다.

    - 상속을 적용시키려면 자식 클래스 선언부의 클래스 이름 뒤에
     키워드 extends를 쓰고, 물려받을 부모 클래스의 이름을 적으시면 됩니다.
*/

public class Warrior extends Player {

    int rage;  // 자식 클래스의 속성

    public Warrior() {
        // 모든 생성자에는 super(); 가 내장되어 있음.
        // 그래야 부모의 속성과 기능이 실존하게 되고, 물려줄 수 있음.
        this.rage = 60;
    }

    public Warrior(String nickName, int rage) {
        super(nickName);
        this.rage = rage;
    }

    public Warrior(String nickName, int hp, int rage) {
        super(nickName, hp);
        this.rage = rage;
    }

    /*
 # 메서드 오버라이딩(재정의)
 - 부모가 물려주는 메서드는 모든 자식들에게 다 맞게 설계되기 힘들기 때문에
  부족한 점이 있거나, 아예 맞지 않는 경우에는 자식 클래스 쪽에서
  내용을 추가하거나 수정할 수 있습니다. 이를 오버라이딩 이라고 합니다.

 - 만약 자식 클래스에서 부모가 물려준 메서드를 새롭게 재 정의한다면
  자식이 수정한 메서드가 우선적으로 호출됩니다.

 - 오버라이딩의 규칙이 있습니다. (4가지 모두 일치해야 오버라이딩 인정)
 1. 부모가 물려주는 메서드와 이름이 똑같을 것!
 2. 부모가 물려주는 메서드와 리턴 타입이 똑같을 것!
 3. 부모가 물려주는 메서드와 매개변수의 선언 방식이 똑같을 것!
 4. 접근제한자는 같거나 more public하게!
 */

    public void dash(){
        System.out.println("돌진! 앞으로!");
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("# rage: "+ rage);
    }
}
