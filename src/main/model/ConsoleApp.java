package main.model;

import java.util.List;

public class ConsoleApp {
    public static void main(String[] args) {
        // Generate sample data
        List<DisasterEvent> events = Simulation.generateSampleData();

        // Initialize prediction model and analyzer
        PredictionModel model = new PredictionModel();
        DisasterAnalyzer analyzer = new DisasterAnalyzer(model);

        // Analyze the data
        analyzer.analyze(events);

        // Calculate and display average risk
        double avgRisk = analyzer.calculateAverageRisk(events);
        System.out.println("Average Risk Score: " + avgRisk);
    }
}
