package ru.pezhe.interview.lesson1.part3;

public class Square extends Shape {

    private final double side;

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

}
