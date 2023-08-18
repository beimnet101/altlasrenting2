package repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import model.RentalOwner;
		

@Repository
public interface RentalOwnerRepository extends JpaRepository<RentalOwner, Long> {
    RentalOwner findByUsernameAndPassword(String username, String password);
    RentalOwner findByUsername(String username);
    @Query("SELECT ro.roles.id FROM RentalOwner ro WHERE ro.id = :rentalOwnerId")
    Long findRoleIdByRentalOwnerId(@Param("rentalOwnerId") Long rentalOwnerId);
}