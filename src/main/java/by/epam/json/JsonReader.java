package by.epam.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonReader {

    private static String readJson (String path) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bR = new BufferedReader(new FileReader(path))) {
            int ch;
            while ((ch= bR.read()) != -1) {
                builder.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static List<Ship> getShips(String path) {
        ObjectMapper mapper = new ObjectMapper();
        List<Ship> shipList;
        Ship[] ships = new Ship[0];
        try {
            ships = mapper.readValue(readJson(path), Ship[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        shipList = Arrays.asList(ships);
        return shipList;
    }
}
