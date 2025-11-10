package Java_Lab5.Task4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть URL сторінки для аналізу (напр., https://uk.wikipedia.org/wiki/Java):");
        String urlString = scanner.nextLine();

        HtmlTagCounter counter = new HtmlTagCounter();

        try {
            Map<String, Integer> tagCounts = counter.countTags(urlString);

            if (tagCounts.isEmpty()) {
                System.out.println("На сторінці не знайдено тегів.");
                return;
            }

            System.out.println("\n--- Теги, відсортовані за АЛФАВІТОМ ---");
            Map<String, Integer> sortedByKey = new TreeMap<>(tagCounts);

            for (Map.Entry<String, Integer> entry : sortedByKey.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("\n--- Теги, відсортовані за КІЛЬКІСТЮ (зростання) ---");

            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(tagCounts.entrySet());

            entryList.sort(Comparator.comparingInt(Map.Entry::getValue));

            for (Map.Entry<String, Integer> entry : entryList) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (MalformedURLException e) {
            System.err.println("ПОМИЛКА: URL введено неправильно. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("ПОМИЛКА: Не вдалося підключитися або прочитати дані з URL. " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Сталася невідома помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
