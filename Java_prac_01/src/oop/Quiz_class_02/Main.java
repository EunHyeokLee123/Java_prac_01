package oop.Quiz_class_02;

public class Main {
    public static void main(String[] args) {
        Television tv = new Television("Samsung TV", 2000000, "Samsung", 55);
        Smartphone phone = new Smartphone("iPhone 13", 890000, "Apple", 256);

        System.out.println("TV Info:");
        tv.displayInfo();

        System.out.println("\nSmartphone Info:");
        phone.displayInfo();
    }
}
