package hh.finalproject.bloodpressure.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BPRepository extends CrudRepository<BloodPressure, Long>{
	List<BloodPressure> findByMeasurementDate(LocalDate measurementDate);

	List<BloodPressure> findByUser(User user);
}
