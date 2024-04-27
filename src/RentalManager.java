import java.util.ArrayList;
import java.util.List;
// RentalManager class managing rental operations
class RentalManager {
    private List<Vehicle> vehicles;
    private List<Customer> customers;

    // Constructor
    public RentalManager() {
        this.vehicles = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    // Method to add a vehicle to the rental system
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Method to add a customer to the rental system
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Method to check if a customer already exists based on phone number
    public boolean customerExists(String name, String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                if (customer.getName().equals(name)){
                    return true;
                }
            }
        }
        return false;
    }

    // Method to find a customer by phone number
    public Customer getCustomerByPhoneNumber(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }
        return null; // Eğer müşteri bulunamazsa null döndürür
    }

    // Method to get the list of vehicles
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    // Method to display available vehicles based on customer type
    public void displayAvailableVehicles(Customer customer) {
        System.out.println("Available Vehicles:");
        int i = 1;
        for (Vehicle vehicle : vehicles) {
            if (customer.isCompany() || !vehicle.getSegment().equals("SUV")) {
                System.out.println(i + "- " + vehicle.getBrand() + " " + vehicle.getModel() + " - Segment: " + vehicle.getSegment());
                i++;
            }
        }
    }

    // Method to calculate rental amount
    public double calculateRentalAmount(Vehicle vehicle, boolean isDaily, int duration) {
        double rentalFee;
        if (isDaily) {
            rentalFee = vehicle.getDailyRentalFee() * duration;
        } else {
            rentalFee = vehicle.getMonthlyRentalFee() * duration;
        }
        return rentalFee;
    }
}

