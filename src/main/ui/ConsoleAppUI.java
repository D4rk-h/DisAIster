package main.ui;
import main.model.*;
import java.util.Scanner;
import java.util.List;

public class ConsoleAppUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome Message
        System.out.println("Welcome to the Natural Disaster Forecast System!");

        // Menu
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Analyze Sample Data");
            System.out.println("2. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Load and analyze data
                List<DisasterEvent> events = Simulation.generateSampleData();
                PredictionModel model = new PredictionModel();
                DisasterAnalyzer analyzer = new DisasterAnalyzer(model);
                analyzer.analyze(events);

                // Display results
                double avgRisk = analyzer.calculateAverageRisk(events);
                System.out.println("\nAverage Risk Score: " + avgRisk);
            } else if (choice == 2) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
