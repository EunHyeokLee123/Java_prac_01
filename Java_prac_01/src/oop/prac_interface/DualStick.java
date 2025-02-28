package oop.prac_interface;

public class DualStick implements AdvancedController{

    @Override
    public void vibrate(int intensity) {
        System.out.println("우이이이잉 강도: "+intensity);
    }

    @Override
    public void offVibrate() {
        System.out.println("이...이이...잉.. 진동 종료");
    }

    @Override
    public void moveCharacter(String direction) {
        System.out.println("조이스틱 "+direction+" 키를 눌러 캐릭터 이동");
    }

    @Override
    public void action() {
        System.out.println("조이스틱 A 버튼을 눌러서 행동을 수행");
    }

    @Override
    public void pause() {
        System.out.println("조이스틱 start 버튼을 눌러서 게임 일시 정지");
    }

    @Override
    public void customizeButton(String config) {
        System.out.println("새로운 커스텀 버튼의 기능은 "+config);
    }

    @Override
    public void specialAction() {
        System.out.println("히야앗 필살기!");
    }
}
