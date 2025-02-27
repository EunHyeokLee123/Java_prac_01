package oop.inherit;

public class Main {

    public static void main(String[] args) {
        Warrior war1 = new Warrior("포퐁전사", 60);
        war1.showStatus();
        Mage mage1 = new Mage("환상법사", 300);
        mage1.showStatus();
    }
}
