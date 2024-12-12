 package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.RentalOwner;
import service.RentalOwnerService;

@RestController
@RequestMapping("/api/rental-owners")
public class RentalOwnerController {
    private final RentalOwnerService rentalOwnerService;

    @Autowired
    public RentalOwnerController(RentalOwnerService rentalOwnerService) {
        this.rentalOwnerService = rentalOwnerService;
    }

    @GetMapping("/{rentalOwnerid}")
    public ResponseEntity<RentalOwner> getRentalOwnerById(@PathVariable Long rentalownerid) {
        RentalOwner rentalOwner = rentalOwnerService.findById(rentalownerid);
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

    @PutMapping("/update/{rentalownerid}")
    public ResponseEntity<RentalOwner> updateRentalOwnerById(
            @PathVariable Long rentalOwnerid,
            @RequestBody RentalOwner rentalOwner) {
        RentalOwner existingRentalOwner = rentalOwnerService.findById(rentalOwnerid);
        if (existingRentalOwner == null) {
            return ResponseEntity.notFound().build();
        }

        rentalOwner.setRentalOwnerid(rentalOwnerid); // Set the ID of the updated rental owner to the requested ID
        RentalOwner updatedRentalOwner = rentalOwnerService.save(rentalOwner);
        return ResponseEntity.ok(updatedRentalOwner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRentalOwnerById(@PathVariable Long rentalOwnerid) {
        rentalOwnerService.deleteById(rentalOwnerid);
        return ResponseEntity.noContent().build();
    }
}


