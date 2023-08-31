package model;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "renter")
public class Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long renterid;

    public Long getRenterid() {
		return renterid;
	}

	public void setRenterid(Long renterid) {
		this.renterid = renterid;
	}

	@Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "renter_roles",
            joinColumns = @JoinColumn(name = "renterid"),
            inverseJoinColumns = @JoinColumn(name = "roleid")
    )
    private Set<Role> roles = new HashSet<>();

    public Renter() {
        // Default constructor required by JPA
    }

    public static Renter createRenter(String email, String password) {
        Renter renter = new Renter();
        renter.setEmail(email);
        renter.setPassword(password);
        // Set other properties as needed
        return renter;
    }

    private void setPassword(String password2) {
		// TODO Auto-generated method stub
		
	}

	private void setEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	// Check if the renter has a specific role
    public boolean hasRole(String roleName) {
        for (Role role : roles) {
            if (role.getName().equals(roleName)) {
                return true;
            }
        }
        return false;
    }

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	
    // Constructors, getters, and setters

    // ...
}