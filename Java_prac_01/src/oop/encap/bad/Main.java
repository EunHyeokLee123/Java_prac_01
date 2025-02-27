package oop.encap.bad;

public class Main {
    public static void main(String[] args) {
        MyBirth my1 = new MyBirth();

        my1.month = 11;
        my1.year = 2000;
        my1.day = 28;

        my1.birthInfo();
    }
}
