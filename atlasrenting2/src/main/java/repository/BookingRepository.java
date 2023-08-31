package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Additional custom queries can be added here if needed
}