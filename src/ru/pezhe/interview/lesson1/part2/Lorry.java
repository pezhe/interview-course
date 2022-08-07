package ru.pezhe.interview.lesson1.part2;

// было "class Lorry extends Car, Movable, Stoppable" - не правильно: Movable и Stoppable - интерфейсы
class Lorry extends Car implements Movable, Stoppable {

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }
    // абстрактный метод open() из Car не был реализован
    @Override
    public void open() {
        System.out.println("Car is opened");
    }

}
