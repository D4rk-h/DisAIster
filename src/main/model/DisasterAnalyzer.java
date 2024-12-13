package main.model;

import java.util.List;

public class DisasterAnalyzer {
    private PredictionModel model;

    public DisasterAnalyzer(PredictionModel model) {
        this.model = model;
    }

    public void analyze(List<DisasterEvent> events) {
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
