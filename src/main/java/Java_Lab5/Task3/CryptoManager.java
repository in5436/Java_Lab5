package Java_Lab5.Task3;

import java.io.*;

public class CryptoManager {

    public void encryptFile(String inputFile, String outputFile, char key) throws IOException {

        try (Reader reader = new FileReader(inputFile);
             Writer writer = new CryptoWriter(new FileWriter(outputFile), key))
        {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        }
    }

    public void decryptFile(String inputFile, String outputFile, char key) throws IOException {

        try (Reader reader = new CryptoReader(new FileReader(inputFile), key);
             Writer writer = new FileWriter(outputFile))
        {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        }
    }
}