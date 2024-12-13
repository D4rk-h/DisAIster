package main.model;

public class DisasterEvent {
    private String eventType;
    private String location;
    private double magnitude;  // e.g., earthquake magnitude or rainfall in mm
    private String date;       // e.g., "2023-07-12"
    private double impactScore;

    // Constructor
    public DisasterEvent(String eventType, String location, double magnitude, String date, double impactScore) {
        this.eventType = eventType;
        this.location = location;
        this.magnitude = magnitude;
        this.date = date;
        this.impactScore = impactScore;
    }

    // Getters and Setters
    public String getEventType() { return eventType; }
    public String getLocation() { return location; }
    public double getMagnitude() { return magnitude; }
    public String getDate() { return date; }
    public double getImpactScore() { return impactScore; }

    public void setImpactScore(double impactScore) { this.impactScore = impactScore; }

    @Override
    public String toString() {
        return String.format("DisasterEvent[type=%s, location=%s, magnitude=%.1f, date=%s, impact=%.1f]",
                eventType, location, magnitude, date, impactScore);
    }
}