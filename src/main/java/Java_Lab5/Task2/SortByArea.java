package Java_Lab5.Task2;

import java.util.Comparator;

public class SortByArea implements Comparator<Shape> {

    @Override
    public int compare(Shape s1, Shape s2) {

        double area1 = s1.calcArea();
        double area2 = s2.calcArea();

        return Double.compare(area1, area2);
    }
}