package oop.prac_abstract;

public class Circle extends Shape{

    private double radius;

    public Circle(double radius, String color) {
        // 부모클래스의 생성자가 특정 매개변수를 받는 생성자만 있다면
        // 자식클래스도 그와 같은 매개변수를 받는 생성자가 반드시 존재해야함.
        super(color);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.pow(this.radius,2) * Math.PI;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }
}
