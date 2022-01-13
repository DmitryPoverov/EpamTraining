package by.epam.json;

import java.util.List;

public class ShipRunner {
    public static void main(String[] args) {

        List<Ship> shipList = JsonReader.getShips("src/main/resources/ships.json");
        for (Ship s : shipList) {
            System.out.println(s);
        }
    }
}
