package model;

public class LoginRequest {
    private String email;
    private String password;
    public String getUsername() {
		return email;
	}
	public void username(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String roleName;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Long getRoleID() {
		// TODO Auto-generated method stub
		return null;
	}

    // Constructors, getters, and setters
    // ...
}
