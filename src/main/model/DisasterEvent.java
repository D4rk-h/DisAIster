package main.model;

public class DisasterEvent {
    private String eventType;
    private String location;
    private double magnitude;
    private String date;
    private double impactScore;

    public DisasterEvent(String eventType, String location, double magnitude, String date, double impactScore) {
        this.eventType = eventType;
        this.location = location;
        this.magnitude = magnitude;
        this.date = date;
        this.impactScore = impactScore;
    }

    public String getEventType() { return eventType; }
    public String getLocation() { return location; }
    public double getMagnitude() { return magnitude; }
    public String getDate() { return date; }
    public double getImpactScore() { return impactScore; }
    public void setImpactScore(double impactScore) { this.impactScore = impactScore; }

    @Override
    public String toString() {
        return String.format("%-12s %-15s %-10.2f %-12s %-10.2f",
                eventType, location, magnitude, date, impactScore);
    }
}
