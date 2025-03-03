package oop.prac_interface;

// 인터페이스를 구현하는 구현체 클래스는 반드시
// 인터페이스의 모든 메소드를 재정의해야 한다.

public class KeyBoardController implements GameController{

    @Override
    public void moveCharacter(String direction) {
        System.out.println("키보드 "+direction+" 키를 눌러 캐릭터 이동");
    }

    @Override
    public void action() {
        System.out.println("키보드 스페이스바를 눌러 행동을 수행");
    }

    @Override
    public void pause() {
        System.out.println("키보드 ESC를 눌러 게임 일시 정지");
    }

    public void molla(){
        System.out.println("몰라. 알 수가 없어.");
    }
}
