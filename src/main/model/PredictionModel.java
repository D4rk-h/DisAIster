package main.model;

public class PredictionModel {
    public double predictRisk(DisasterEvent event) {
        double risk = 0;

        if (event.getEventType().equalsIgnoreCase("Earthquake")) {
            risk = event.getMagnitude() * 12;
        } else if (event.getEventType().equalsIgnoreCase("Flood")) {
            risk = event.getMagnitude() * 0.4;
        } else if (event.getEventType().equalsIgnoreCase("Storm")) {
            risk = event.getMagnitude() * 0.6;
        }

        return Math.min(risk, 100.0);
    }

    public double predictFutureRisk(String location, String disasterType, int monthsAhead) {
        if (disasterType.equalsIgnoreCase("Earthquake")) {
            return Math.random() * 30 + 50; // Simular riesgo entre 50 y 80
        } else if (disasterType.equalsIgnoreCase("Flood")) {
            return Math.random() * 20 + 40; // Simular riesgo entre 40 y 60
        } else {
            return Math.random() * 15 + 35; // Riesgo genérico
        }
    }
} 
