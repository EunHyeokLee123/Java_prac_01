package oop.pack;

// 다른 패키지에 있는 객체를 생성할 때는 반드시 import해야함

import oop.pack.fruit.Apple;
import oop.pack.fruit.Banana;
import oop.pack.fruit.Melon;

// fruit 디렉토리의 모든 클래스 import하려면 *을 씀.
import oop.pack.fruit.*;

public class Main {
    public static void main(String[] args) {
        // 다른 패키지 객체 생성하면 자동으로 import문 생김
        Apple a1 = new Apple();
        Banana b1 = new Banana();
        Melon m1 = new Melon();

        // 위치는 다르지만 객체명이 같기에 import문이 생기는게 아니라
        // 해당 객체의 경로가 붙게 됨.
        oop.pack.juice.Apple a2 = new oop.pack.juice.Apple();
        // 다만 이런 경우는 흔치않다.

    }

}
