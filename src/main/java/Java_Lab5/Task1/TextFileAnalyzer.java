package Java_Lab5.Task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileAnalyzer {

    public String findLineWithMaxWords(String filename) throws IOException, FileNotFoundException {

        String bestLine = null;
        int maxWordCount = -1;

        try (FileReader fileReader = new FileReader(filename);
             BufferedReader reader = new BufferedReader(fileReader)){

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String[] words = currentLine.trim().split("\\s+");
                int currentWordCount = words.length;

                if (currentLine.trim().isEmpty()) {
                    currentWordCount = 0;
                }

                if (currentWordCount > maxWordCount) {
                    maxWordCount = currentWordCount;
                    bestLine = currentLine;
                }
            }
        }

        return bestLine;
    }
}