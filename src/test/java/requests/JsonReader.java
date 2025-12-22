package  requests;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class JsonReader {

    public static String readJsonFileAsString(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line);
            }
        }
        return contentBuilder.toString();
    }

    public static void main(String[] args) {
        String filePath = "E:\\IT\\test.json"; // Replace with your JSON file path
        try {
            String jsonString = readJsonFileAsString(filePath);
            System.out.println("JSON content as string:\n" + jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}