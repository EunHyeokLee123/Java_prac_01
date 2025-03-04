package oop.Quiz_class_02;

public class ElectronicProduct {
    private String productName;
    private double price;
    private String manufacturer;

    public ElectronicProduct(String productName, double price, String manufacturer) {
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
    }


    public void displayInfo() {
        System.out.println(productName+", 가격: "+ price
        +", 제조사: "+manufacturer);
    }
}
