package Java_Lab5.Task2;

import java.io.*;

public class ShapeFileManager {

    public void saveShapes(Shape[] shapes, String filename) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(shapes);
            System.out.println("Фігури успішно збережено у файл: " + filename);
        }
    }

    public Shape[] loadShapes(String filename) throws IOException, ClassNotFoundException {
        Shape[] shapes;

        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
            shapes = (Shape[]) ois.readObject();
            System.out.println("Фігури успішно завантажено з файлу: " + filename);
        }
        return shapes;
    }
}
