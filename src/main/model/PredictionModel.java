package main.model;

public class PredictionModel {
    // Simple rule-based prediction
    public double predictRisk(DisasterEvent event) {
        double risk = 0;

        // Example logic: Higher magnitude or rainfall increases risk
        if (event.getEventType().equalsIgnoreCase("Earthquake")) {
            risk = event.getMagnitude() * 10; // Risk based on magnitude
        } else if (event.getEventType().equalsIgnoreCase("Flood")) {
            risk = event.getMagnitude() * 0.5; // Risk based on rainfall
        }

        // Normalize the risk to 0-100 range
        return Math.min(risk, 100.0);
    }
}