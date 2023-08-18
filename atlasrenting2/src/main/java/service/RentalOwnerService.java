package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.RentalOwner;
import repository.RentalOwnerRepository;

import java.util.List;

@Service
public class RentalOwnerService {
	private final RentalOwnerRepository rentalOwnerRepository;


    RentalOwnerService(RentalOwnerRepository rentalOwnerRepository) {
        this.rentalOwnerRepository = rentalOwnerRepository;
    }

  
   
  
    public RentalOwner findByName(Long id) {
        return rentalOwnerRepository.findById(id).orElse(null);
    }
    
    public RentalOwner findById(Long id) {
        return rentalOwnerRepository.findById(id).orElse(null);
    }
   
        public RentalOwner authenticate(String username, String password) {
            return rentalOwnerRepository.findByUsernameAndPassword(username, password);
        }

        public RentalOwner findByEmail(String username) {
            return rentalOwnerRepository.findByUsername(username);
        }

        public Long findRoleIdByRentalOwnerId(Long rentalOwnerId) {
            return rentalOwnerRepository.findRoleIdByRentalOwnerId(rentalOwnerId);
        }
    
    

    public List<RentalOwner> findAll() {
        return rentalOwnerRepository.findAll();
    }

    public RentalOwner save(RentalOwner rentalOwner) {
        return rentalOwnerRepository.save(rentalOwner);
    }

    public void deleteById(Long id) {
        rentalOwnerRepository.deleteById(id);
    }
}