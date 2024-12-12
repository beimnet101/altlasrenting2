
package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import model.Admin;
import model.Role;
import repository.AdminRepository;
@Service
public class AdminService {
    private final AdminRepository adminRepository;

    private ProductService productService;
    private RentalOwnerService rentalOwnerService;

    @Autowired
    public AdminService(AdminRepository adminRepository,ProductService productService,RentalOwnerService rentalOwnerService) {
        this.adminRepository = adminRepository;

        this.productService = productService;
        this.rentalOwnerService = rentalOwnerService;
    }
    
    
    public Admin authenticate(String username, String password) {
        Admin admin = adminRepository.findByUsernameAndPassword(username, password);
        if (admin != null) {
            Role role = admin.getRole();
            if (role != null && role.getName().equals("ROLE_ADMIN")) {
                return admin; // Authentication successful
            }
        }
        return null; // Authentication failed
    }

    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

  
   
 @Transactional
        public void deleteRentalOwnerAndProducts(Long rentalOwnerid) {
        productService.deleteProductsByRentalOwnerId(rentalOwnerid, rentalOwnerid);
        rentalOwnerService.deleteRentalOwner(rentalOwnerid);
        }

        // Other admin-related methods

    }
    
    
