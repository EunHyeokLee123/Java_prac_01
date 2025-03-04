package oop.Quiz_class_02;

public class Smartphone extends ElectronicProduct{

    private int stroageCapacity;

    public Smartphone(String productName, double price, String manufacturer,  int stroageCapacity) {
        super(productName, price, manufacturer);
        this.stroageCapacity = stroageCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("저장용량: "+ stroageCapacity);
    }
}
