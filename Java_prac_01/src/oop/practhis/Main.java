package oop.practhis;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player();
        p1.nickName = "James";
        Player p2 = new Player("Hamel");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        Player p3 = new Player();
        p3.nickName = "James";
        Player p4 = new Player("Hamel");
    }
}
