package model;

// Klasse til kunder i systemet
// Jeg har taget de felter som opgaven nævner (navn, adresse, kontaktinfo, kørekort)
public class Customer {
    private int customerId;   // PK (laves auto i databasen)
    private String name;
    private String address;
    private String zip;
    private String city;
    private String mobilePhone;
    private String phone;
    private String email;
    private String driverLicenseNumber; // unik værdi
    private String driverSince;         // hvornår kunden fik kørekort (jeg gemmer bare som String)

    // tom constructor - bruges tit når man laver objekt og fylder data på bagefter
    public Customer() {}

    // constructor til når jeg vil lave en ny kunde direkte
    public Customer(int customerId, String name, String address, String zip, String city,
                    String mobilePhone, String phone, String email,
                    String driverLicenseNumber, String driverSince) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.mobilePhone = mobilePhone;
        this.phone = phone;
        this.email = email;
        this.driverLicenseNumber = driverLicenseNumber;
        this.driverSince = driverSince;
    }

    // getters og setters (ikke så , men nødvendige hvis man skal bruge DAO)
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getZip() { return zip; }
    public void setZip(String zip) { this.zip = zip; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getMobilePhone() { return mobilePhone; }
    public void setMobilePhone(String mobilePhone) { this.mobilePhone = mobilePhone; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDriverLicenseNumber() { return driverLicenseNumber; }
    public void setDriverLicenseNumber(String driverLicenseNumber) { this.driverLicenseNumber = driverLicenseNumber; }

    public String getDriverSince() { return driverSince; }
    public void setDriverSince(String driverSince) { this.driverSince = driverSince; }

    // toString - så jeg kan printe en kunde og se noget læsbart
    @Override
    public String toString() {
        return customerId + ": " + name + " (" + driverLicenseNumber + ")";
    }
}
