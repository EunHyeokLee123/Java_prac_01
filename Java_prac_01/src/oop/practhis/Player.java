package oop.practhis;

public class Player {

    String nickName;
    int level;
    int hp;

    // alt + insert
    /*@Override
    public String toString() {
        return "Player{" +
                "nickName='" + nickName + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                '}';
    }*/

    // this는 현재 호출한 객체의 주소를 의미함.
    public Player() {
        System.out.println("플레이어의 기본" +
                " 생성자가 호출됨.");
        System.out.println("this = " + this);
        level = 1;
        hp = 50;
    }

    // this가 붙으면 이 객체의 필드 속 정보로 특정 짓게함.
    public Player(String nickName) {
        this.nickName = nickName;
        System.out.println("플레이어의 이름이 " +
              nickName + "인 생성자가 호출됨.");
        System.out.println("this = " + this);
        level = 1;
        hp = 50;
    }
}
