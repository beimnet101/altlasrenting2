package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import model.RentalOwner;
import service.RentalOwnerService;

import java.util.List;

@RestController
@RequestMapping("/api/rental-owners")
public class RentalOwnerController {
    private final RentalOwnerService rentalOwnerService;

    @Autowired
    public RentalOwnerController(RentalOwnerService rentalOwnerService) {
        this.rentalOwnerService = rentalOwnerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalOwner> getRentalOwnerById(@PathVariable Long id) {
        RentalOwner rentalOwner = (RentalOwner) rentalOwnerService.findById(id);
        if (rentalOwner != null) {
            return ResponseEntity.ok(rentalOwner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<RentalOwner>> getAllRentalOwners() {
        List<RentalOwner> rentalOwners = rentalOwnerService.findAll();
        return ResponseEntity.ok(rentalOwners);
    }

    @PostMapping
    public ResponseEntity<RentalOwner> createRentalOwner(@RequestBody RentalOwner rentalOwner) {
        RentalOwner createdRentalOwner = rentalOwnerService.save(rentalOwner);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRentalOwner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRentalOwnerById(@PathVariable Long id) {
        rentalOwnerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}