package oop.Quiz_class_03;

public class Store {
    private static int totalSales = 0;

    public static void addSale(int amount){
        totalSales += amount;
    }

    public static int getTotalSales(){
        return totalSales;
    }
}
