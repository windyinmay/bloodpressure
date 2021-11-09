package fi.haagahelia.finalProject.bloodpressure.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class User {
	private Long userId;
	private String username;
	private String role;
	private String harshPassword;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Bloodpressure> bloodpressure;
	
	public User(Long userId, String username, String role, String harshPassword) {
		super();
		this.userId = userId;
		this.username = username;
		this.role = role;
		this.harshPassword = harshPassword;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getHarshPassword() {
		return harshPassword;
	}

	public void setHarshPassword(String harshPassword) {
		this.harshPassword = harshPassword;
	}

	public List<Bloodpressure> getBloodpressure() {
		return bloodpressure;
	}

	public void setBloodpressure(List<Bloodpressure> bloodpressure) {
		this.bloodpressure = bloodpressure;
	}
	
}
