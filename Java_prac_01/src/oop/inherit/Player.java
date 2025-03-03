package oop.inherit;

/*
    # 부모 클래스, 상위 클래스 (Parent, super class)

    - 데이터를 다른 클래스에게 상속하는 클래스를 부모 클래스라고 부릅니다.
    - 상속을 사용하면 데이터를 물려받는 클래스에게 부모 클래스의
     멤버변수(필드)와 메서드가 상속됩니다. 단, 생성자는 상속되지 않습니다.
*/

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

    // 현재 캐릭터 정보를 출력
    public void showStatus() {
        System.out.println("\n======= Character's Info ========");
        System.out.println("# name: " + this.nickName);
        System.out.println("# level: " + this.level);
        System.out.println("# hp: " + this.hp);
    }

}
