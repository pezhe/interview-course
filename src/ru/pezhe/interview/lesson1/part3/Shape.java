package ru.pezhe.interview.lesson1.part3;

public abstract class Shape {

    private final String color;

    public Shape(String color) {
        this.color = color;
    }

    abstract double getArea();

    public String getColor() {
        return color;
    }

}
