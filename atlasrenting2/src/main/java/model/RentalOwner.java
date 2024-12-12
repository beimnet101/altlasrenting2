package model;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rental_owner")
public class RentalOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalOwnerid;

    public Long getRentalOwnerid() {
		return rentalOwnerid;
	}

	public void setRentalOwnerid(Long rentalOwnerid) {
		this.rentalOwnerid = rentalOwnerid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "rental_owner_roles",
            joinColumns = @JoinColumn(name = "rentalownerid"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public RentalOwner() {
        // Default constructor required by JPA
    }

    public static RentalOwner createRentalOwner(String email, String password) {
        RentalOwner rentalOwner = new RentalOwner();
        rentalOwner.setEmail(email);
        rentalOwner.setPassword(password);
        // Set other properties as needed
        return rentalOwner;
    }

    private void setPassword(String password2) {
		// TODO Auto-generated method stub
		
	}

	private void setEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	// Check if the rental owner has a specific role
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
    @OneToMany(mappedBy = "rentalOwner", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();


    // Constructors, getters, and setters

    // ...
}