package main.ui;

import main.model.*;
import java.util.Scanner;
import java.util.List;


public class ConsoleAppUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Natural Disaster Forecast System!");

        List<DisasterEvent> events = Simulation.generateSampleData();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Analyze Sample Data");
            System.out.println("2. Add a New Disaster Event");
            System.out.println("3. Exit");

            int choice;
            while (true) {
                System.out.print("Your choice: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }

            if (choice == 1) {
                PredictionModel model = new PredictionModel();
                DisasterAnalyzer analyzer = new DisasterAnalyzer(model);

                System.out.println("\n===== Disaster Analysis Results =====");
                System.out.println(String.format("%-15s %-15s %-10s %-15s %-10s",
                        "TYPE", "LOCATION", "MAGNITUDE", "DATE", "IMPACT"));
                for (DisasterEvent event : events) {
                    System.out.println(String.format("%-15s %-15s %-10.2f %-15s %-10.2f",
                            event.getEventType(), event.getLocation(), event.getMagnitude(), event.getDate(), event.getImpactScore()));
                }
                double avgRisk = analyzer.calculateAverageRisk(events);
                System.out.println("\nAverage Risk Score: " + avgRisk);
                System.out.println("=====================================");
            } else if (choice == 2) {
                System.out.println("Enter the disaster details:");
                System.out.println("Enter the disaster details:");
                System.out.print("Type: ");
                String type = scanner.next();
                System.out.print("Location: ");
                String location = scanner.next();

                double magnitude;
                do {
                    System.out.print("Magnitude: ");
                    magnitude = scanner.nextDouble();
                    if (magnitude <= 0) {
                        System.out.println("Magnitude must be a positive number. Please try again.");
                    }
                } while (magnitude <= 0);

                System.out.print("Date (YYYY-MM-DD): ");
                String date = scanner.next();

                double impact;
                do {
                    System.out.print("Impact: ");
                    impact = scanner.nextDouble();
                    if (impact < 0 || impact > 100) {
                        System.out.println("Impact must be between 0 and 100. Please try again.");
                    }
                } while (impact < 0 || impact > 100);

                boolean exists = events.stream().anyMatch(e ->
                        e.getEventType().equalsIgnoreCase(type) &&
                                e.getLocation().equalsIgnoreCase(location) &&
                                e.getDate().equals(date));
                if (exists) {
                    System.out.println("This event already exists. Please try again.");
                } else {
                    DisasterEvent newEvent = new DisasterEvent(type, location, magnitude, date, impact);
                    events.add(newEvent);
                    System.out.println("New disaster event added successfully.");
                }
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
