package oop.poly.player;

public class Main {
    public static void main(String[] args) {
        Warrior w1 = new Warrior("전사1", 60);
        Warrior w2 = new Warrior("전사2", 60);
        Mage m1 = new Mage("마법사1", 100);
        Mage m2 = new Mage("마법사2", 100);


        m1.blizzard(w1, w2, m2);

        Hunter h1 = new Hunter("사냥꾼1", "냐옹이1");
        Hunter h2 = new Hunter("사냥꾼2", "냐옹이2");

        h1.magicArraow(w1);
        h1.magicArraow(m1);
        h1.magicArraow(h2);

        Player[] all  = {w1, w2, m1, m2, h1, h2};

        for (Player pl : all) {
            pl.showStatus();
        }
    }
}
