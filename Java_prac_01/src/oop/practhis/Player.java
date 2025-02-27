package oop.practhis;

public class Player {

    String nickName;
    int level;
    int hp;


    public Player() {
        // this는 현재 호출한 객체의 주소를 의미함.
        // System.out.println("this = " + this);
        level = 1;
        hp = 50;
    }

    // this가 붙으면 이 객체의 필드 속 정보로 특정 짓게함.
    public Player(String nickName) {
        this();
        this.nickName = nickName;
    }

    Player(String nickName, int hp){
        this(nickName);
        this.hp = hp;
    }

    void attack(Player target){
        if (target != this) {
            target.hp -= 10;
            System.out.printf(this.nickName + "이 " + target.nickName +
                    "을 공격하여 10의 데미지를 입혔습니다. \n");
            if(target.hp < 0){
                System.out.printf(target.nickName + " 님이 사망하였습니다. \n");
                System.out.println("다시 부활합니다.");
            }
            else{
                System.out.printf(target.nickName+" 님의 남은 체력은 "+
                        target.hp+"입니다.\n");
            }
        }
        else {
            System.out.println("자기 자신은 공격할 수 없습니다.");
        }
    }

    // alt + insert
    @Override
    public String toString() {
        return "Player{" +
                "nickName='" + nickName + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                '}';
    }

}
