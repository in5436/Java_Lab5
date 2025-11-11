package Java_Lab5.Task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagCounter {

    private static final Pattern TAG_PATTERN = Pattern.compile("<([a-zA-Z0-9]+)");

    public Map<String, Integer> countTags(String urlString) throws IOException, MalformedURLException {
        Map<String, Integer> tagCounts = new HashMap<>();

        URL url = new URL(urlString);

        java.net.URLConnection conn = url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

        try (InputStreamReader isr = new InputStreamReader(conn.getInputStream());
             BufferedReader reader = new BufferedReader(isr))
        {

            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = TAG_PATTERN.matcher(line);

                while (matcher.find()) {
                    String tagName = matcher.group(1).toLowerCase();

                    int currentCount = tagCounts.getOrDefault(tagName, 0);
                    tagCounts.put(tagName, currentCount + 1);
                }
            }
        }

        return tagCounts;
    }
}