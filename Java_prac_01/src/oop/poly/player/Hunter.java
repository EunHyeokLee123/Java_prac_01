package oop.poly.player;

public class Hunter extends Player{

    String pet;

    public Hunter(String nickName, String pet){
        super(nickName);
        this.pet = pet;
    }

    public void magicArraow(Player p1){
        System.out.println(this.nickName+"님이 "+ p1.nickName+"님에게 매직" +
                " 애로우를 시전했습니다!");
        if(p1 instanceof Warrior){
            p1.hp-=10;
            System.out.println(p1.nickName+"님(전사)이 10의 " +
                    "피해를 입었습니다.");
            System.out.println(p1.nickName+"님의 남은 체력: "+
                    p1.hp);
        } else if (p1 instanceof Mage) {
            p1.hp-=20;
            System.out.println(p1.nickName+"님(마법사)이 20의 " +
                    "피해를 입었습니다.");
            System.out.println(p1.nickName+"님의 남은 체력: "+
                    p1.hp);
        } else if (p1 instanceof Hunter) {
            p1.hp-=15;
            System.out.println(p1.nickName+"님(사냥꾼)이 15의 " +
                    "피해를 입었습니다.");
            System.out.println(p1.nickName+"님의 남은 체력: "+
                    p1.hp);
        }
        System.out.println("----------------------------");
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("펫의 이름은 "+pet+"입니다.");
    }
}
