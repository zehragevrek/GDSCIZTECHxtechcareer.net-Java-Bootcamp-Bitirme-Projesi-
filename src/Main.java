import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentalManager rentalManager = new RentalManager();
        Scanner scanner = new Scanner(System.in);

        // Adding vehicles to the rental system
        Vehicle sedan1 = new Vehicle("Toyota", "Camry", "Sedan", 100, 2000);
        Vehicle suv1 = new Vehicle("Jeep", "Wrangler", "SUV", 150, 4000);
        Vehicle hatchback1 = new Vehicle("A", "b", "Hatchbag", 200, 6000);

        rentalManager.addVehicle(sedan1);
        rentalManager.addVehicle(suv1);
        rentalManager.addVehicle(hatchback1);

        while (true){
            // Getting customer information
            System.out.println("Welcome!");
            System.out.println("Please enter '0' to log in or if you're new enter '1' to sign up: ");
            char selection = scanner.next().charAt(0);

            if (selection == '0'){
                System.out.print("Name: ");
                String name = scanner.next();
                System.out.print("Phone Number: ");
                String phoneNumber = scanner.next();
                if (!rentalManager.customerExists(name, phoneNumber)){
                    System.out.println("Customer not found!");
                    break;
                }
                Customer customer = rentalManager.getCustomerByPhoneNumber(phoneNumber);
                rentalManager.displayAvailableVehicles(customer);
            }
            else if (selection == '1'){
                System.out.println("Name: ");
                String name = scanner.next();
                System.out.print("Phone Number: ");
                String phoneNumber = scanner.next();
                System.out.print("ID or Tax Number: ");
                String idOrTaxNumber = scanner.next();
                System.out.print("Is the customer a company? (true/false): ");
                boolean isCompany = scanner.nextBoolean();

                // Checking if the customer already exists
                if (!rentalManager.customerExists(name,   phoneNumber)) {
                    Customer customer = new Customer(name, phoneNumber, idOrTaxNumber, isCompany);
                    rentalManager.addCustomer(customer);
                    System.out.println("Customer added successfully.");
                } else {
                    System.out.println("Customer already exists.");
                }
                Customer customer = rentalManager.getCustomerByPhoneNumber(phoneNumber);
                rentalManager.displayAvailableVehicles(customer);
            }
            else {
                System.out.println("Invalid input! Please try again.");
                break;
            }


            // Displaying available vehicles based on customer type
            //Customer customer = rentalManager.getCustomerByPhoneNumber(phoneNumber);
            //rentalManager.displayAvailableVehicles(customer);

            // Asking for rental details
            System.out.println("Enter rental details:");
            System.out.print("Which car do you want to choose, please enter the brand: ");
            String brand = scanner.next();
            System.out.print("Enter rental type (daily/monthly): ");
            String rentalType = scanner.next();
            System.out.print("How many days/months do you want to rent: ");
            int duration = scanner.nextInt();

            // Finding the vehicle
            Vehicle selectedVehicle = null;
            for (Vehicle vehicle : rentalManager.getVehicles()) {
                if (vehicle.getBrand().equalsIgnoreCase(brand)) {
                    selectedVehicle = vehicle;
                    break;
                }
            }

            // Calculating rental amount
            if (selectedVehicle != null) {
                boolean isDailyRental = rentalType.equalsIgnoreCase("daily");
                double rentalAmount = rentalManager.calculateRentalAmount(selectedVehicle, isDailyRental, duration);
                System.out.println("Rental amount: $" + rentalAmount);
            } else {
                System.out.println("Vehicle not found.");
            }
            System.out.println("Do you want to continue (y/n)?");
            char selection2 = scanner.next().charAt(0);
            if (selection2 != 'y'){
                scanner.close();
                break;
            }

        }
    }

}
