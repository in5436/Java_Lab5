package Java_Lab5.Task4;

// Імпорти для роботи з мережею (URL) та I/O (потоками)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
// Імпорти для зберігання даних (HashMap) та Регулярних виразів (Pattern/Matcher)
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (Вимога 4) Окремий клас для роботи з даними.
 * Його робота - підключитися до URL, завантажити HTML
 * і порахувати всі теги.
 */
public class HtmlTagCounter {

    // 1. "Регулярний вираз" (RegEx) для пошуку тегів.
    // Це "шаблон пошуку", який ми будемо використовувати.
    // "<" - шукає символ '<'
    // ([a-zA-Z0-9]+) - "Захоплююча група" (дужки):
    //    [a-zA-Z0-9] - шукає будь-яку літеру (велику/малу) або цифру
    //    + - "один або більше разів"
    // Цей шаблон знайде <p> і <h1>, але проігнорує </p> (бо там /)
    // і (бо там !--).
    private static final Pattern TAG_PATTERN = Pattern.compile("<([a-zA-Z0-9]+)");

    /**
     * Головний метод нашого аналізатора.
     * @param urlString - Рядок з URL (напр., "https://wikipedia.org")
     * @return - Map (словник), де "ключ" = тег, "значення" = кількість
     * @throws IOException - Якщо є проблеми з мережею або читанням
     * @throws MalformedURLException - Якщо URL введено неправильно (напр., "htp://bad")
     */
    public Map<String, Integer> countTags(String urlString) throws IOException, MalformedURLException {

        // 2. Створюємо "Словник" (Map) для зберігання наших лічильників
        // "Ключ" - це назва тегу (String), "Значення" - це лічильник (Integer)
        Map<String, Integer> tagCounts = new HashMap<>();

        // 3. Створюємо об'єкт URL з рядка
        URL url = new URL(urlString);

        // 4. Встановлюємо з'єднання та "маскуємось" під браузер
        // Це потрібно, бо Вікіпедія блокує прості Java-запити.
        java.net.URLConnection conn = url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

        // 5. Встановлюємо "ланцюжок потоків" для читання з Інтернету
        // (Вимога 6) Використовуємо 'try-with-resources' для авто-закриття
        try (InputStreamReader isr = new InputStreamReader(conn.getInputStream());
             BufferedReader reader = new BufferedReader(isr))
        {
            // url.openStream() - відкриває "трубу" (InputStream) до сайту.
            //                  Вона передає сирі БАЙТИ.
            // new InputStreamReader(...) - "обгортка", яка перетворює
            //                  БАЙТИ на СИМВОЛИ (літери).
            // new BufferedReader(...) - "обгортка", яка дає нам зручний
            //                  метод .readLine() для читання СИМВОЛІВ рядками.

            String line;
            // 5. Читаємо сторінку рядок за рядком
            while ((line = reader.readLine()) != null) {

                // 6. На кожному рядку шукаємо теги за нашим шаблоном (RegEx)
                Matcher matcher = TAG_PATTERN.matcher(line);

                // 'matcher.find()' - шукає НАСТУПНИЙ тег у рядку
                while (matcher.find()) {

                    // 'matcher.group(1)' - дістає текст з "захоплюючої групи" (дужок)
                    // Тобто, з "<p>" він дістане "p".
                    // .toLowerCase() - приводимо до нижнього регістру,
                    // щоб <P> і <p> рахувалися як один тег.
                    String tagName = matcher.group(1).toLowerCase();

                    // 7. Оновлюємо лічильник у "словнику"
                    // 'getOrDefault(tagName, 0)' - каже:
                    // "Дай мені поточний лічильник для 'tagName',
                    // а якщо його ще немає, дай мені 0".
                    int currentCount = tagCounts.getOrDefault(tagName, 0);
                    tagCounts.put(tagName, currentCount + 1);
                }
            }
        }

        return tagCounts; // Повертаємо заповнений "словник"
    }
}