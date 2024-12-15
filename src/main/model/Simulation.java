package main.model;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    public static List<DisasterEvent> generateSampleData() {
        List<DisasterEvent> events = new ArrayList<>();
        events.add(new DisasterEvent("Earthquake", "California", 6.5, "2023-07-12", 65.0));
        events.add(new DisasterEvent("Flood", "Florida", 300, "2023-08-20", 90.0));
        events.add(new DisasterEvent("Storm", "Texas", 150, "2023-09-01", 70.0));
        return events;
    }
}
