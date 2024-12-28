package entity;

import org.json.JSONArray;

import java.io.FileReader;

public class JsonData {
    public static JSONArray MusicData;
    public JsonData() {
        try (FileReader reader1 = new FileReader("C:\\Users\\92075\\IdeaProjects\\opCalc3\\MusicData.json")) {
            // Read the JSON file and convert it to a string
            int c1;
            StringBuilder sb1 = new StringBuilder();
            while ((c1 = reader1.read()) != -1) {
                sb1.append((char) c1);
            }
            String jsonStrResponse = sb1.toString();
            MusicData = new JSONArray(jsonStrResponse);
        } catch (Exception ignore){

        }
    }
}
