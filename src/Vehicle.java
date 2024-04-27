// Vehicle class representing different types of vehicles
class Vehicle {
    private String brand;
    private String model;
    private String segment;
    private double dailyRentalFee;
    private double monthlyRentalFee;

    // Constructor
    public Vehicle(String brand, String model, String segment, double dailyRentalFee, double monthlyRentalFee) {
        this.brand = brand;
        this.model = model;
        this.segment = segment;
        this.dailyRentalFee = dailyRentalFee;
        this.monthlyRentalFee = monthlyRentalFee;
    }

    // Getter methods
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSegment() {
        return segment;
    }

    public double getDailyRentalFee() {
        return dailyRentalFee;
    }

    public double getMonthlyRentalFee() {
        return monthlyRentalFee;
    }
}