package controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

import model.Renter;
import service.RenterService;

import java.util.List;

	@RestController
	@RequestMapping("/renters")
	public class RenterController {
	    private final RenterService renterService;

	    @Autowired
	    public RenterController(RenterService renterService) {
	        this.renterService = renterService;
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Renter> getRenterById(@PathVariable Long id) {
	        Renter renter = renterService.findById(id);
	        if (renter != null) {
	            return ResponseEntity.ok(renter);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<Renter>> getAllRenters() {
	        List<Renter> renters = renterService.findAll();
	        return ResponseEntity.ok(renters);
	    }

	    @PostMapping("/createrenter")
	    public ResponseEntity<Renter> createRenter(@RequestBody Renter renter) {
	        Renter createdRenter = renterService.save(renter);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdRenter);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteRenterById(@PathVariable Long id) {
	        renterService.deleteById(id);
	        return ResponseEntity.noContent().build();
	          
	    }
	}

