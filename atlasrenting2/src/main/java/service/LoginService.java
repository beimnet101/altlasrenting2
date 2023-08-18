package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import model.Admin;
import model.LoginRequest;
import model.RentalOwner;
import model.Renter;
import model.Role;
import repository.AdminRepository;
import repository.RentalOwnerRepository;
import repository.RenterRepository;
import repository.RoleRepository;


@Service
public class LoginService {
    private final RenterRepository renterRepository;
    private final RentalOwnerRepository rentalOwnerRepository;
    private final AdminRepository adminRepository;

    public LoginService(RenterRepository renterRepository,
                        RentalOwnerRepository rentalOwnerRepository,
                        AdminRepository adminRepository) {
        this.renterRepository = renterRepository;
        this.rentalOwnerRepository = rentalOwnerRepository;
        this.adminRepository = adminRepository;
    }

    public String login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Renter renter = renterRepository.findByUsername(username);
        if (renter != null && renter.getPassword().equals(password) && renter.hasRole("ROLE_USER")) {
            return "Renter login successful";
        }

        RentalOwner rentalOwner = rentalOwnerRepository.findByUsername(username);
        if (rentalOwner != null && rentalOwner.getPassword().equals(password) && rentalOwner.hasRole("ROLE_OWNER")) {
            return "Rental owner login successful";
        }

        Admin admin = adminRepository.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password) && admin.hasRole("ROLE_ADMIN")) {
            return "Admin login successful";
        }

        return "Invalid credentials";
    }

	public User authenticate(String username, String password, Long roleId, String roleName) {
		// TODO Auto-generated method stub
		return null;
	}
}
