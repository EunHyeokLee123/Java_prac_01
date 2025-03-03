package oop.poly.car;

public class CarShop {

     /*
        Mammals
           |
         Person
           |
        Student

        Mammals m = new Student();
        m instanceof Person -> ???
     */

    public void carPrice(Car c){
        if(c instanceof Sonata){
            System.out.println("쏘나타는 3,000만원입니다.");
        } else if (c instanceof Porsche) {
            System.out.println("포르쉐는 13,000만원입니다.");
        } else if (c instanceof Tesla) {
            System.out.println("테슬라는 8,000만원입니다.");
        }
        else {
            System.out.println("없는 차종인데?");
        }
    }
}
