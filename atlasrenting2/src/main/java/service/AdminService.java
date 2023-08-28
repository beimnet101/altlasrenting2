
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

    public Long findRoleIdByAdminId(Long roleId) {
        return adminRepository.findRoleIdByAdminId(roleId);
        
        
        
    }
    

 @Transactional
        public void deleteRentalOwnerAndProducts(Long roleId) {
        productService.deleteProductsByRentalOwnerId(roleId);
        rentalOwnerService.deleteRentalOwner(roleId);
        }

        // Other admin-related methods

    }
    
    
