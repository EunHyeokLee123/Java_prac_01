package oop.constructor;

public class Main {
    public static void main(String[] args) {
        Phone ph1 = new Phone();
        ph1.color = "Red";
        ph1.model = "IPhone 14 plus";
        ph1.price = 1350000;
        ph1.showSpec();
        Phone ph2 = new Phone();
        ph2.color = "Midnight Black";
        ph2.model = "IPhone 13";
        ph2.price = 1250000;
        Phone ph3 =  new Phone("Galaxy s25", "다라이블루", 990000);
        ph3.showSpec();
        Phone ph4 = new Phone();
        ph4.showSpec();
    }
}
