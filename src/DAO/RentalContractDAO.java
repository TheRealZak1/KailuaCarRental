package DAO;

import model.RentalContract;
import java.util.List;

public class RentalContractDAO {

    // Create
    public void addRentalContract(RentalContract contract) {
        // TODO: INSERT INTO RentalContract (...)
    }

    // Read
    public RentalContract getRentalContractById(int rentalId) {
        // TODO: SELECT * FROM RentalContract WHERE rental_id=?
        return null;
    }

    public List<RentalContract> getAllRentalContracts() {
        // TODO: SELECT * FROM RentalContract
        return null;
    }

    // Update (fx afslut kontrakt)
    public void updateRentalContract(RentalContract contract) {
        // TODO: UPDATE RentalContract SET ... WHERE rental_id=?
    }

    // Delete
    public void deleteRentalContract(int rentalId) {
        // TODO: DELETE FROM RentalContract WHERE rental_id=?
    }
}
