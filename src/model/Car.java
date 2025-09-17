package model;

// Klasse til biler i systemet
// Jeg har taget felterne fra opgaven (mærke, model, brændstof, registrering, km osv.)
public class Car {
    private String regNumber;   // Primærnøgle (nummerplade)
    private String brand;
    private String model;
    private String fuelType;
    private String firstRegistration; // kunne have brugt LocalDate, men jeg holder det simpelt som String
    private int odometerKm;
    private int categoryId;     // Fremmednøgle til CarCategory (bruger jeg ikke så meget i Java)

    // tom constructor - bruges tit når man henter data fra DB
    public Car() {}

    // constructor til når jeg laver en ny bil selv
    public Car(String regNumber, String brand, String model, String fuelType,
               String firstRegistration, int odometerKm, int categoryId) {
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.firstRegistration = firstRegistration;
        this.odometerKm = odometerKm;
        this.categoryId = categoryId;
    }

    // getters og setters (bare standard ting)
    public String getRegNumber() { return regNumber; }
    public void setRegNumber(String regNumber) { this.regNumber = regNumber; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public String getFirstRegistration() { return firstRegistration; }
    public void setFirstRegistration(String firstRegistration) { this.firstRegistration = firstRegistration; }

    public int getOdometerKm() { return odometerKm; }
    public void setOdometerKm(int odometerKm) { this.odometerKm = odometerKm; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    // toString - så jeg kan se noget læsbart når jeg printer bilen
    @Override
    public String toString() {
        return regNumber + " - " + brand + " " + model + " (" + fuelType + ")";
    }
}
