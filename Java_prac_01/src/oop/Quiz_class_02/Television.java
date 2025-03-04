package oop.Quiz_class_02;

public class Television extends ElectronicProduct{

    private int screenSize;

    public Television(String productName,  double price, String manufacturer, int screenSize) {
        super(productName, price, manufacturer);
        this.screenSize = screenSize;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("화면크기: "+screenSize);
    }
}
