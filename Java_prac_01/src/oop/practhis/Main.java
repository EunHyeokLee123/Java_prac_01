package oop.practhis;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player();
        p1.nickName = "James";
        Player p2 = new Player("Hamel");
        p1.attack(p1);
        p1.attack(p2);
        Player p3 = new Player("Ronaldo", 44);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}
