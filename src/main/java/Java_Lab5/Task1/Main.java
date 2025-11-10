package Java_Lab5.Task1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть повний шлях до файлу (напр., C:/files/text.txt):");
        String filePath = scanner.nextLine();

        TextFileAnalyzer analyzer = new TextFileAnalyzer();

        try {
            String longestLine = analyzer.findLineWithMaxWords(filePath);

            if (longestLine != null) {
                System.out.println("\nРядок з максимальною кількістю слів:");
                System.out.println(longestLine);
            } else {
                System.out.println("Файл порожній.");
            }

        } catch (FileNotFoundException e) {
            System.err.println("ПОМИЛКА: Файл не знайдено за шляхом " + filePath);
        } catch (IOException e) {
            System.err.println("ПОМИЛКА: Не вдалося прочитати файл. " + e.getMessage());
        }

        scanner.close();
    }
}
