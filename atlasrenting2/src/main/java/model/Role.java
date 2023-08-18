package model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(nullable = false)
    private String roleName;

	public Role(Long roleId, String roleName) {
		super();
		this.roleId=roleId;
		this.roleName=roleName;
		;
	}

	public Role getName() {
		// TODO Auto-generated method stub
		return null;
	}

    // Constructors, getters, and setters
}	
