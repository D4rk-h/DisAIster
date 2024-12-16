package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {

    private static final String[] LOCATIONS = {"California", "Florida", "Texas", "New York", "Kansas"};
    private static final String[] DISASTER_TYPES = {"Earthquake", "Flood", "Storm", "Tornado"};
    private static final Random RANDOM = new Random();

    public static List<DisasterEvent> generateSampleData() {
        List<DisasterEvent> events = new ArrayList<>();

        for (String location : LOCATIONS) {
            for (String disasterType : DISASTER_TYPES) {
                // Generar múltiples eventos para cada tipo en cada ubicación
                int numEvents = RANDOM.nextInt(4) + 2; // Entre 2 y 5 eventos por tipo y ubicación
                for (int i = 0; i < numEvents; i++) {
                    String date = generateRandomDate();
                    double magnitude = generateRandomMagnitude(disasterType);
                    events.add(new DisasterEvent(disasterType, location, magnitude, date, 0));
                }
            }
        }

        return events;
    }

    // Generar una fecha aleatoria en el rango de los últimos 5 años
    private static String generateRandomDate() {
        int year = RANDOM.nextInt(5) + 2018; // Entre 2018 y 2023
        int month = RANDOM.nextInt(12) + 1; // Mes entre 1 y 12
        int day = RANDOM.nextInt(28) + 1; // Día entre 1 y 28
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    // Generar una magnitud aleatoria dependiendo del tipo de desastre
    private static double generateRandomMagnitude(String disasterType) {
        switch (disasterType) {
            case "Earthquake":
                return 3 + RANDOM.nextDouble() * 7; // Magnitud entre 3 y 10
            case "Flood":
                return 100 + RANDOM.nextDouble() * 900; // Cantidad de lluvia entre 100 y 1000 mm
            case "Storm":
                return 50 + RANDOM.nextDouble() * 250; // Velocidad del viento entre 50 y 300 km/h
            case "Tornado":
                return 1 + RANDOM.nextDouble() * 5; // Clasificación entre F1 y F5
            default:
                return 1 + RANDOM.nextDouble() * 10; // Valor genérico
        }
    }
}
