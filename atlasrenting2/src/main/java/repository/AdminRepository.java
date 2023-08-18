
package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
        Admin findByUsernameAndPassword(String username, String password);
        Admin findByUsername(String username);
        @Query("SELECT a.roles.id FROM Admin a WHERE a.id = :adminId")
        Long findRoleIdByAdminId(@Param("adminId") Long adminId);
    }

    
