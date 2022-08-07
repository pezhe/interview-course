package ru.pezhe.interview.lesson1.part3;

public class Circle extends Shape {

    private final double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double getArea() {
        return 2.0 * Math.PI * radius;
    }

}
