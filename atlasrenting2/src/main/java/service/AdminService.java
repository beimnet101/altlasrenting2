
package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.Admin;
import model.Role;
import repository.AdminRepository;
@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
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

    public Long findRoleIdByAdminId(Long adminId) {
        return adminRepository.findRoleIdByAdminId(adminId);
    }
}