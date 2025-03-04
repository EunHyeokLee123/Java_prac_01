package oop.Quiz_class_03;

public class Product {

    private String productName;
    private int price;

    public Product(String productName, int price) {
        this.price = price;
        this.productName = productName;
    }

    public void sellProduct(){
        System.out.println(productName+"을 판매했습니다.");
        Store.addSale(this.price);
        System.out.println("현재 총 판매액은 "+Store.getTotalSales()+"원입니다.");
    }
}
