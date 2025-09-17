package model;

// Klasse til lejekontrakter
// Binder en kunde sammen med en bil i en bestemt periode
public class RentalContract {
    private int rentalId;           // PK
    private int customerId;         // FK → Customer
    private String carRegNumber;    // FK → Car
    private String fromDatetime;    // jeg bruger bare String (kunne have brugt LocalDateTime)
    private String toDatetime;
    private int maxKm;
    private int startOdometerKm;
    private Integer returnOdometerKm; // Kan være null hvis bilen ikke er afleveret endnu
    private String status;            // fx "active", "returned", "cancelled"

    // tom constructor
    public RentalContract() {}

    // constructor hvor jeg kan lave en kontrakt på én gang
    public RentalContract(int rentalId, int customerId, String carRegNumber,
                          String fromDatetime, String toDatetime, int maxKm,
                          int startOdometerKm, Integer returnOdometerKm, String status) {
        this.rentalId = rentalId;
        this.customerId = customerId;
        this.carRegNumber = carRegNumber;
        this.fromDatetime = fromDatetime;
        this.toDatetime = toDatetime;
        this.maxKm = maxKm;
        this.startOdometerKm = startOdometerKm;
        this.returnOdometerKm = returnOdometerKm;
        this.status = status;
    }

    // getters og setters (basic)
    public int getRentalId() { return rentalId; }
    public void setRentalId(int rentalId) { this.rentalId = rentalId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getCarRegNumber() { return carRegNumber; }
    public void setCarRegNumber(String carRegNumber) { this.carRegNumber = carRegNumber; }

    public String getFromDatetime() { return fromDatetime; }
    public void setFromDatetime(String fromDatetime) { this.fromDatetime = fromDatetime; }

    public String getToDatetime() { return toDatetime; }
    public void setToDatetime(String toDatetime) { this.toDatetime = toDatetime; }

    public int getMaxKm() { return maxKm; }
    public void setMaxKm(int maxKm) { this.maxKm = maxKm; }

    public int getStartOdometerKm() { return startOdometerKm; }
    public void setStartOdometerKm(int startOdometerKm) { this.startOdometerKm = startOdometerKm; }

    public Integer getReturnOdometerKm() { return returnOdometerKm; }
    public void setReturnOdometerKm(Integer returnOdometerKm) { this.returnOdometerKm = returnOdometerKm; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // toString så jeg kan se kontrakten hurtigt i konsollen
    @Override
    public String toString() {
        return rentalId + ": Customer=" + customerId + ", Car=" + carRegNumber + ", Status=" + status;
    }
}
