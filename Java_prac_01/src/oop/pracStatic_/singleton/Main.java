package oop.pracStatic_.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        // s가 private이라서 직접 접근 불가능
        //   Singleton.s = null;
        s1.method1(); s1.method2();
    }

}
