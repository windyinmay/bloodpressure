package fi.haagahelia.finalProject.bloodpressure.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bloodpressure {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long BPId;
	private int upper;
	private int lower;
	private int pulse;
	private LocalTime measurementTime;
	private LocalDate measurementDate;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	public Bloodpressure(User user, int upper, int lower, int pulse, LocalTime measurementTime,
			LocalDate measurementDate) {
		super();
		this.upper = upper;
		this.lower = lower;
		this.pulse = pulse;
		this.measurementTime = measurementTime;
		this.measurementDate = measurementDate;
		this.user = user;
	}

	public Bloodpressure() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getBPId() {
		return BPId;
	}

	public void setBPId(Long bPId) {
		BPId = bPId;
	}

	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}

	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public LocalDate getMeasurementDate() {
		return measurementDate;
	}

	public void setMeasurementDate(LocalDate measurementDate) {
		this.measurementDate = measurementDate;
	}

	public LocalTime getMeasurementTime() {
		return measurementTime;
	}

	public void setMeasurementTime(LocalTime measurementTime) {
		this.measurementTime = measurementTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
