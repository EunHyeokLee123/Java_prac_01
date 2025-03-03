package oop.inherit;

public class Mage extends Player{
    int mp;

    public Mage(int mp) {
        this.mp = mp;
    }

    public Mage(String nickName, int mp) {
        super(nickName);
        this.mp = mp;
    }

    public Mage(String nickName, int hp, int mp) {
        super(nickName, hp);
        this.mp = mp;
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("mp: "+this.mp);
    }
}
