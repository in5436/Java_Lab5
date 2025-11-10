package Java_Lab5.Task2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ShapeFileManager fileManager = new ShapeFileManager();
        Shape[] shapes = new Shape[0];

        while (true) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Створити стандартний набір фігур (10 шт)");
            System.out.println("2. Завантажити фігури з файлу");
            System.out.println("3. Зберегти фігури у файл");
            System.out.println("4. Показати всі фігури");
            System.out.println("5. Порахувати загальну площу");
            System.out.println("6. Сортувати за площею");
            System.out.println("7. Сортувати за кольором");
            System.out.println("0. Вийти");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        shapes = createDefaultShapes();
                        System.out.println("Створено 10 стандартних фігур.");
                        break;
                    case "2":
                        System.out.print("Введіть ім'я або повний шлях до файлу (напр., shapes.dat або C:/files/shapes.dat): ");
                        String loadFile = scanner.nextLine();
                        shapes = fileManager.loadShapes(loadFile);
                        break;
                    case "3":
                        System.out.print("Введіть ім'я або повний шлях для збереження (напр., shapes.dat або C:/files/shapes.dat): ");
                        String saveFile = scanner.nextLine();
                        fileManager.saveShapes(shapes, saveFile);
                        break;
                    case "4":
                        System.out.println("--- Поточні фігури ---");
                        printShapes(shapes);
                        break;
                    case "5":
                        calculateTotalArea(shapes);
                        break;
                    case "6":
                        System.out.println("--- Сортування за Площею ---");
                        Arrays.sort(shapes, new SortByArea());
                        printShapes(shapes);
                        break;
                    case "7":
                        System.out.println("--- Сортування за Кольором ---");
                        Arrays.sort(shapes, new SortByColor());
                        printShapes(shapes);
                        break;
                    case "0":
                        System.out.println("До побачення!");
                        return;
                    default:
                        System.out.println("Невірний вибір. Спробуйте ще раз.");
                }
            } catch (Exception e) {
                System.err.println("ПОМИЛКА: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void printShapes(Shape[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Масив фігур порожній.");
            return;
        }
        for (Shape shape : arr) {
            System.out.println(shape);
        }
    }

    public static Shape[] createDefaultShapes() {
        Shape[] shapes = new Shape[10];
        shapes[0] = new Rectangle("Roman", 10, 7);
        shapes[1] = new Circle("Red", 5.5);
        shapes[2] = new Triangle("Green", 6, 3);
        shapes[3] = new Circle("Blue", 3);
        shapes[4] = new Rectangle("Yellow", 2, 4);
        shapes[5] = new Triangle("Red", 10, 5);
        shapes[6] = new Rectangle("Green", 8, 8);
        shapes[7] = new Circle("Yellow", 1);
        shapes[8] = new Triangle("Blue", 7, 7);
        shapes[9] = new Rectangle("Oleksandr", 12, 2);
        return shapes;
    }

    public static void calculateTotalArea(Shape[] shapes) {
        if (shapes == null || shapes.length == 0) {
            System.out.println("Масив фігур порожній. Неможливо рахувати площу.");
            return;
        }

        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calcArea();
        }
        System.out.println("\nЗагальна площа всіх фігур: " + totalArea);
    }
}