package Java_Lab5.Task3;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CryptoManager manager = new CryptoManager();

        try {

            System.out.println("Оберіть режим:");
            System.out.println("1. Шифрування");
            System.out.println("2. Дешифрування");
            String mode = scanner.nextLine();

            System.out.print("Введіть шлях до ВХІДНОГО файлу: ");
            String inputFile = scanner.nextLine();

            System.out.print("Введіть шлях до ВИХІДНОГО файлу: ");
            String outputFile = scanner.nextLine();

            System.out.print("Введіть ключовий СИМВОЛ (напр., 'a'): ");
            String keyString = scanner.nextLine();

            if (keyString.length() != 1) {
                throw new IllegalArgumentException("Ключ має бути одним символом.");
            }
            char key = keyString.charAt(0);

            if ("1".equals(mode)) {
                manager.encryptFile(inputFile, outputFile, key);
                System.out.println("Файл успішно зашифровано!");
            } else if ("2".equals(mode)) {
                manager.decryptFile(inputFile, outputFile, key);
                System.out.println("Файл успішно дешифровано!");
            } else {
                System.out.println("Невірний режим.");
            }

        } catch (IOException e) {
            System.err.println("Помилка роботи з файлом: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Сталася помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}