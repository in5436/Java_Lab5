package Java_Lab5.Task2;

import java.io.Serializable;

public class Triangle extends Shape implements Serializable {

    private static final long serialVersionUID = 1L;

    private final double base;
    private final double height;

    public Triangle(String shapeColor, double base, double height) {
        super(shapeColor);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle [" + super.toString() + ", base= " + base + ", height= " + height + ", area= " + this.calcArea() + "]";
    }

}