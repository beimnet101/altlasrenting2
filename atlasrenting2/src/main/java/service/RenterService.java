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

    public Long findRoleIdByRenterId(Long renterid) {
        return renterRepository.findRoleIdByRenterId(renterid);
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
	

    public List<Renter> getAllRenters() {
        return renterRepository.findAll();
    }

    public Renter getRenterById(Long renterid) {
        return renterRepository.findById(renterid).orElse(null);
    }

    public Renter createRenter(Renter renter) {
        return renterRepository.save(renter);
    }

    //public Renter updateRenter(Long id, Renter renter) {
      //  Renter existingRenter = renterRepository.findById(id).orElse(null);
        //if (existingRenter != null) {
          //  existingRenter.setName(renter.getName());
            //existingRenter.setEmail(renter.getEmail());
            //existingRenter.setPassword(renter.getPassword());
            // Set other properties as needed
            //return renterRepository.save(existingRenter);
       // }
        //return null;
    

    public void deleteRenter(Long renterid) {
        renterRepository.deleteById(renterid);
    }
}