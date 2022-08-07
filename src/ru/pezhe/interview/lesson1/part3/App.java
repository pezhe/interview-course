package ru.pezhe.interview.lesson1.part3;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Shape> shapesList = new ArrayList<>();
        shapesList.add(new Square("white", 2.0));
        shapesList.add(new Circle("black", 1.0));
        shapesList.add(new Triangle("yellow", 2.0, 2.0, 3.0));
        shapesList.forEach(s -> System.out.printf("Shape: type=%s, color=%s, area=%.2f)\n",
                s.getClass().getSimpleName(),
                s.getColor(),
                s.getArea()));
    }
}
