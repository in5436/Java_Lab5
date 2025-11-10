package Java_Lab5.Task2;

import java.util.Comparator;

public class SortByColor implements Comparator<Shape> {

    @Override
    public int compare(Shape s1, Shape s2) {
        String color1 = s1.shapeColor;
        String color2 = s2.shapeColor;

        return color1.compareTo(color2);
    }
}