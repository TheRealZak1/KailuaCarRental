package DAO;

import model.Car;
import java.util.List;

public class CarDAO {

    // Create
    public void addCar(Car car) {
        // TODO: INSERT INTO Car (...)
    }

    // Read
    public Car getCarByRegNumber(String regNumber) {
        // TODO: SELECT * FROM Car WHERE reg_number=?
        return null;
    }

    public List<Car> getAllCars() {
        // TODO: SELECT * FROM Car
        return null;
    }

    // Update
    public void updateCar(Car car) {
        // TODO: UPDATE Car SET ... WHERE reg_number=?
    }

    // Delete
    public void deleteCar(String regNumber) {
        // TODO: DELETE FROM Car WHERE reg_number=?
    }
}
