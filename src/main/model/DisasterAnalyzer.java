package main.analyzer;

import main.model.DisasterEvent;
import main.model.PredictionModel;

import java.util.List;

public class DisasterAnalyzer {
    private PredictionModel model;

    public DisasterAnalyzer(PredictionModel model) {
        this.model = model;
    }

    public void analyze(List<DisasterEvent> events) {
        System.out.println("\n===== Disaster Data Analysis =====");
        System.out.println(String.format("%-12s %-15s %-10s %-12s %-10s",
                "Type", "Location", "Magnitude", "Date", "Impact"));
        System.out.println("-----------------------------------------------------------");
        for (DisasterEvent event : events) {
            double risk = model.predictRisk(event);
            event.setImpactScore(risk);
            System.out.println(event);
        }
    }

    public double calculateAverageRisk(List<DisasterEvent> events) {
        return events.stream()
                .mapToDouble(DisasterEvent::getImpactScore)
                .average()
                .orElse(0.0);
    }
}
