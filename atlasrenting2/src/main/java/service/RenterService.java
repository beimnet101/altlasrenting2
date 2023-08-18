package service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import model.Renter;
import repository.RenterRepository;

import java.util.List;

@Service
public class RenterService {
    private final RenterRepository renterRepository;

    @Autowired
    public RenterService(RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    public Renter authenticate(String email, String password) {
        return renterRepository.findByUsernameAndPassword(email, password);
    }

    public Renter findByUsername(String username) {
        return renterRepository.findByUsername(username);
    }

    public Long findRoleIdByRenterId(Long renterId) {
        return renterRepository.findRoleIdByRenterId(renterId);
    }

	    public Renter findById(Long id) {
	        return renterRepository.findById(id).orElse(null);
	    }
	
	    public List<Renter> findAll() {
	        return renterRepository.findAll();
	    }

	    public Renter save(Renter renter) {
	        return renterRepository.save(renter);
	    }

	    public void deleteById(Long id) {
	        renterRepository.deleteById(id);
	    }
	}

