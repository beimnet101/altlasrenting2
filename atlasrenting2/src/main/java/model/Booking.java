package model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "renter_id")
    private Long renterid;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;
    @Column(name = "cancelled")
    private boolean cancelled;


    // Additional fields, constructors, getters, and setters

    public Booking() {
    }

    public Booking(Long renterid, Long productId, LocalDateTime bookingDate) {
        this.renterid = renterid;
        this.productId = productId;
        this.bookingDate = bookingDate;
       
    }

    // Getters and setters

    public Long getbookingId() {
        return id;
    }

    public void setbookingId(Long id) {
        this.id = id;
    }

    public Long getRenterId() {
        return renterid;
    }

    public void setRenterId(Long renterid) {
        this.renterid = renterid;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }


    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    // Other methods or business logic specific to the Booking entity

    // ...
}