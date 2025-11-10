package Java_Lab5.Task2;

import java.io.Serializable;

public abstract class Shape implements Drawable, Serializable {

    private static final long serialVersionUID = 1L;

    protected String shapeColor;

    public Shape(String shapeColor) {

        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public String toString() {

        return "shapeColor=" + shapeColor;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a shape with " + this.toString());

    }
}
