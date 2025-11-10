package Java_Lab5.Task2;

import java.io.Serializable;

public class Rectangle extends Shape implements Serializable {

    private static final long serialVersionUID = 1L;

    private final double width;
    private final double height;

    public Rectangle(String shapeColor, double width, double height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle [" + super.toString() + ", width= " + width + ", height= " + height + ", area= " + this.calcArea() + "]";
    }

}