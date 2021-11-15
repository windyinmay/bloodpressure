package hh.finalproject.bloodpressure.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usertable")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long userId;
	
	//Username with unique constraint
	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String passwordHash;
	
	@Column(name = "age", nullable = false)
	private int age;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<BloodPressure> bloodpressures;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username,String passwordHash, int age, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.age = age;
		this.role = role;
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


	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<BloodPressure> getBloodpressures() {
		return bloodpressures;
	}

	public void setBloodpressures(List<BloodPressure> bloodpressures) {
		this.bloodpressures = bloodpressures;
	}
		
}
