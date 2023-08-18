package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.RentalOwner;
import model.Renter;

@Repository

public interface RenterRepository extends JpaRepository<Renter, Long> {
    Renter findByUsernameAndPassword(String username, String password);
    Renter findByUsername(String usename);
    @Query("SELECT r.roles.id FROM Renter r WHERE r.id = :renterId")
    Long findRoleIdByRenterId(@Param("renterId") Long renterId);
}