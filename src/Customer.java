// Customer class representing both individual customers and companies
class Customer {
    private String name;
    private String phoneNumber;
    private String idOrTaxNumber;
    private boolean isCompany;

    // Constructor
    public Customer(String name, String phoneNumber, String idOrTaxNumber, boolean isCompany) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.idOrTaxNumber = idOrTaxNumber;
        this.isCompany = isCompany;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getIdOrTaxNumber() {
        return idOrTaxNumber;
    }

    public boolean isCompany() {
        return isCompany;
    }
}