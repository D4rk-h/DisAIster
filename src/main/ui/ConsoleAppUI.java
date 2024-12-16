package main.ui;

import main.model.DisasterEvent;
import main.model.PredictionModel;
import main.model.Simulation;
import main.model.DisasterAnalyzer;

import java.util.List;
import java.util.Scanner;

public class ConsoleAppUI {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        List<DisasterEvent> events = Simulation.generateSampleData();
        PredictionModel model = new PredictionModel();
        DisasterAnalyzer analyzer = new DisasterAnalyzer(model);

        System.out.println("Welcome to the Natural Disaster Prediction System!");
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Analyze current disasters");
            System.out.println("2. Predict future risks");
            System.out.println("3. Add a new disaster event");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                analyzer.analyze(events);
                System.out.printf("Average Risk Score: %.2f\n", analyzer.calculateAverageRisk(events));
            } else if (choice == 2) {
                System.out.print("Enter location: ");
                String location = scanner.nextLine();
                System.out.print("Enter disaster type (e.g., Earthquake, Flood, Storm): ");
                String type = scanner.nextLine();
                System.out.print("Enter months ahead for prediction: ");
                int months = scanner.nextInt();

                double futureRisk = model.predictFutureRisk(location, type, months);
                System.out.printf("Predicted Risk in %s for %s in %d months: %.2f\n",
                        location, type, months, futureRisk);
            } else if (choice == 3) {
                System.out.print("Enter disaster type: ");
                String type = scanner.nextLine();
                System.out.print("Enter location: ");
                String location = scanner.nextLine();
                System.out.print("Enter magnitude: ");
                double magnitude = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter date (YYYY-MM-DD): ");
                String date = scanner.nextLine();

                DisasterEvent newEvent = new DisasterEvent(type, location, magnitude, date, 0);
                double risk = model.predictRisk(newEvent);
                newEvent.setImpactScore(risk);
                events.add(newEvent);
                System.out.println("New disaster event added successfully!");
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
