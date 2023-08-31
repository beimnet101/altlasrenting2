package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import model.Booking;
import repository.BookingRepository;

import java.util.NoSuchElementException;


@Service
@Transactional
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(Booking booking) {
        // Additional logic for creating a booking
        // You can call the necessary repository methods or perform any other business logic here
        return bookingRepository.save(booking);
    }

    public boolean cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new NoSuchElementException("Booking not found"));

        if (!booking.isCancelled()) {
            booking.setCancelled(true);
            bookingRepository.save(booking);
            return true;
        } else {
            return false;
        }
    }

    // Additional methods for managing bookings (retrieve, update, etc.) can be added here
}